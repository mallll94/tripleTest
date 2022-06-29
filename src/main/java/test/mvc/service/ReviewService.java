package test.mvc.service;

import test.mvc.dto.ReviewDTO;

public interface ReviewService {

	/**
	 * 등록
	 * */
	public int insertReview(ReviewDTO dto);
	
	/**
	 * 수정
	 * */
	public int updateReview(ReviewDTO dto);
	
	/**
	 * 삭제
	 * */
	public int deleteReview(ReviewDTO dto);
}
