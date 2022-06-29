package test.mvc.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import test.mvc.domain.Place;
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
	public int insertReview(ReviewDTO dto) {	
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

		reviewRep.save(new Review(dto.getReviewId(), dto.getContent(), photoDB, place , users));
		
		point=addPoint(point,dto,place);	
		statusPoint(point,users);

		
		return 0;
		
	}

	@Override
	public int updateReview(ReviewDTO dto) {
		
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
		statusPoint(point, users);
		
		
		
		return 0;
	}

	@Override
	public int deleteReview(ReviewDTO dto) {
		
		return 0;
	}

	//포인트 이력 작성
	public void statusPoint(int point,Users users) {
		String status =null;
		if(users.getUserPoint().getUserPoint() > point) {
			status =users.getUserId()+"님의 포인트가 "+(users.getUserPoint().getUserPoint()-point)+" 감소되었습니다.";
			
			users.getUserPoint().setUserPoint(point);
			pointStatusRep.save(new UserPointStatus(null, users, users.getUserPoint(), status));
		}else if(users.getUserPoint().getUserPoint() < point) {
			status =users.getUserId()+"님의 포인트가 "+(point-users.getUserPoint().getUserPoint())+" 증가되었습니다.";
			
			users.getUserPoint().setUserPoint(point);
			pointStatusRep.save(new UserPointStatus(null, users, users.getUserPoint(), status));
		}

		
		
	}
	
	//리뷰생성시 포인트 계산
	public int addPoint(int point,ReviewDTO dto,Place place) {
		int result = point;
		if(!dto.getContent().equals("") || dto.getContent()!=null)result +=1;	
		if(dto.getAttachedPhotoIds()!=null)result+=1;
		if(place.getReviewCheck()==0) {
			result+=1;
			place.setReviewCheck(1);
		}
		
		return result;
	}
	
	//리뷰수정시 포인트 계산 및 수정
	public int updatePoint(int point,ReviewDTO dto,String photoDB) {
		int result = point;
		Review review=reviewRep.findById(dto.getReviewId()).orElse(null);
		
		if(review.getContent().equals("") || review.getContent()==null) {
			if(!dto.getContent().equals("") || dto.getContent()!=null) {
				review.setContent(dto.getContent());
				point +=1;
			}	
		}else {
			if(!dto.getContent().equals("") || dto.getContent()!=null) {
				review.setContent(dto.getContent());
			}	
		}

		if(review.getAttachedPhotoIds().equals("") || review.getAttachedPhotoIds()==null) {
			if(dto.getAttachedPhotoIds()!=null) {
				review.setAttachedPhotoIds(photoDB);
				point+=1;
			}
		}else {
			if(dto.getAttachedPhotoIds()!=null) {
				review.setAttachedPhotoIds(photoDB);
			}
		}
		
		return result;
	}
}
