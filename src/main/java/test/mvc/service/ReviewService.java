package test.mvc.service;

import java.util.List;

import test.mvc.domain.Review;
import test.mvc.domain.UserPointStatus;
import test.mvc.dto.ReviewDTO;

public interface ReviewService {

	/**
	 * 등록
	 * */
	public void insertReview(ReviewDTO dto);
	
	/**
	 * 수정
	 * */
	public void updateReview(ReviewDTO dto);
	
	/**
	 * 삭제
	 * */
	public void deleteReview(ReviewDTO dto);
	
	/**
	 * 삭제
	 * */
	public List<Review> selectReview(String placeId);
	
	/**
	 * 내 상황 포인트 상황 조회
	 * */
	public int selectPoint(String userId);
	
	/**
	 * 내 포인트 이력 조회
	 * */
	public List<UserPointStatus> selectPointStatusList(String userId);
}
