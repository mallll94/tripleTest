package test.mvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.querydsl.core.BooleanBuilder;

import lombok.RequiredArgsConstructor;
import test.mvc.domain.Place;
import test.mvc.domain.QReview;
import test.mvc.domain.Review;
import test.mvc.domain.UserPointStatus;
import test.mvc.domain.Users;
import test.mvc.dto.ReviewDTO;
import test.mvc.repository.PlaceRepository;
import test.mvc.repository.ReviewRepository;
import test.mvc.repository.UserPointStatusRepository;
import test.mvc.repository.UsersRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewServiceImpl implements ReviewService {

	private final ReviewRepository reviewRep;
	private final UsersRepository usersRep;
	private final PlaceRepository placeRep;
	private final UserPointStatusRepository pointStatusRep;
	
	@Override
	public void insertReview(ReviewDTO dto) {	
		Users users = usersRep.findById(dto.getUserId()).orElse(null);
		Place place = placeRep.findById(dto.getPlaceId()).orElse(null);
		
		String photoDB = "";
		int point =users.getUserPoint().getUserPoint();
		
		if(dto.getAttachedPhotoIds()!=null) {
			for(int i = 0 ;i <dto.getAttachedPhotoIds().length;i++) {
				if(i==dto.getAttachedPhotoIds().length-1) {
					photoDB +=dto.getAttachedPhotoIds()[i];
				}else {
					photoDB +=dto.getAttachedPhotoIds()[i]+"/";
				}
			}
		}
		
		QReview reviews = QReview.review;
		BooleanBuilder builder = new BooleanBuilder();
		builder.and(reviews.users.userId.eq(dto.getUserId()));
		Review review = reviewRep.findOne(builder).orElse(null);
		
		if(review == null) {
			reviewRep.save(new Review(dto.getReviewId(), dto.getContent(), photoDB, place , users));
			point=addPoint(point,dto,place);	
			statusPoint(point,users,dto.getPlaceId());
		}else {
			System.out.println("이미 작성");
			new RuntimeException("이미 작성했습니다.");
		}

		
	}

	@Override
	public void updateReview(ReviewDTO dto) {
		
		Users users = usersRep.findById(dto.getUserId()).orElse(null);
		String photoDB = "";
		int point =users.getUserPoint().getUserPoint();	
		
		if(dto.getAttachedPhotoIds()!=null) {
			for(int i = 0 ;i <dto.getAttachedPhotoIds().length;i++) {
				if(i==dto.getAttachedPhotoIds().length-1) {
					photoDB +=dto.getAttachedPhotoIds()[i];
				}else {
					photoDB +=dto.getAttachedPhotoIds()[i]+"/";
				}
			}
		}
		point =updatePoint(point, dto, photoDB);
		statusPoint(point, users,dto.getPlaceId());

	}

	@Override
	public void deleteReview(ReviewDTO dto) {	
		Review review=reviewRep.findById(dto.getReviewId()).orElse(null);
		Users users = usersRep.findById(dto.getUserId()).orElse(null);
		
		int point = users.getUserPoint().getUserPoint()+deletePoint(dto,review);

		statusPoint(point, users,dto.getPlaceId());
		reviewRep.deleteById(dto.getReviewId());

	}
	
	@Override
	public List<Review> selectReview(String placeId) {	
		QReview review = QReview.review;
		BooleanBuilder builder = new BooleanBuilder();	
		builder.and(review.place.placeId.eq(placeId));
		List<Review> reviews=(List<Review>) reviewRep.findAll(builder);
		return reviews;
	}

	@Override
	public int selectPoint(String userId) {
		Users users = usersRep.findById(userId).orElse(null);
		return users.getUserPoint().getUserPoint();
	}

	@Override
	public List<UserPointStatus> selectPointStatusList(String userId) {
		Users users = usersRep.findById(userId).orElse(null);
		return users.getUserPointStatus();
	}

	
	//포인트 이력 작성
	public void statusPoint(int point,Users users,String placeId) {
		String status =null;
		if(users.getUserPoint().getUserPoint() > point) {
			status =users.getUserId()+"님이 "+placeId+"에서 서비스를 이용하여 포인트가 "+(users.getUserPoint().getUserPoint()-point)+" 감소되었습니다.";
			
			users.getUserPoint().setUserPoint(point);
			pointStatusRep.save(new UserPointStatus(null, users, users.getUserPoint(), status));
		}else if(users.getUserPoint().getUserPoint() < point) {
			status =users.getUserId()+"님이 "+placeId+"에서 서비스를 이용하여 포인트가 "+(point-users.getUserPoint().getUserPoint())+" 증가되었습니다.";
			
			users.getUserPoint().setUserPoint(point);
			pointStatusRep.save(new UserPointStatus(null, users, users.getUserPoint(), status));
		}

	}
	
	//리뷰생성시 포인트 계산
	public int addPoint(int point,ReviewDTO dto,Place place) {
		int result = point;
		if(!dto.getContent().equals("") || dto.getContent()!=null)result +=1;	
		if(dto.getAttachedPhotoIds()!=null)result+=1;
		if(place.getReviewCheck()==null) {
			result+=1;
			place.setReviewCheck(dto.getUserId());
		}
		
		return result;
	}
	
	//리뷰수정시 포인트 계산 및 수정
	public int updatePoint(int point,ReviewDTO dto,String photoDB) {
		int result = point;
		Review review=reviewRep.findById(dto.getReviewId()).orElse(null);
		
		if(review.getContent()==null||review.getContent().equals("")) {
			if(dto.getContent().equals("") || dto.getContent()==null) {
				result +=0;
			}else {
				review.setContent(dto.getContent());
				result +=1;
			}	
		}else {
			if(dto.getContent()==null || dto.getContent().equals("")) {
				review.setContent("");
				result -=1;
			}else {
				review.setContent(dto.getContent());
			}	
		}

		if(review.getAttachedPhotoIds()==null ||review.getAttachedPhotoIds().equals("")) {
			if(dto.getAttachedPhotoIds().length!=0) {
				review.setAttachedPhotoIds(photoDB);
				result+=1;
			}
		}else {
			if(dto.getAttachedPhotoIds().length!=0) {
				review.setAttachedPhotoIds(photoDB);
			}else {
				review.setAttachedPhotoIds("");
				result -=1;
			}
		}
		return result;
	}
	
	//리뷰전체 삭제시 포인트 계산
	public int deletePoint(ReviewDTO dto,Review review) {
		int point = 0;
		
		if(dto.getUserId().equals(review.getPlace().getReviewCheck())) {
			review.getPlace().setReviewCheck(null);
			point -=1;
		}
		if(review.getContent()!=null||!review.getContent().equals(""))point-=1;
		if(review.getAttachedPhotoIds() !=null||!review.getAttachedPhotoIds().equals(""))point-=1;

		return point;
	}

}
