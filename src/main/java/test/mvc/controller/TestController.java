package test.mvc.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import test.mvc.domain.Review;
import test.mvc.domain.UserPointStatus;
import test.mvc.dto.ReviewDTO;
import test.mvc.service.ReviewService;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class TestController {

	private final ReviewService reviewService;
	
	
	@RequestMapping("/event")
	public void review(String type,String action,String reviewId,String content,String [] attachedPhotoIds,String userId, String placeId) {
		ReviewDTO dto = new ReviewDTO(reviewId, content, attachedPhotoIds, userId, placeId);
		
		if(action.equals("ADD")) {
			reviewService.insertReview(dto);
		}else if(action.equals("MOD")) {	
			reviewService.updateReview(dto);
		}else if(action.equals("DELETE")) {
			reviewService.deleteReview(dto);
		}

	}

	@RequestMapping("/select")
	public Map<String, Object> pointSelectAll(String userId,String placeId) {
		Map<String, Object> map = new HashMap<String, Object>();
		int myPoint = reviewService.selectPoint(userId);
		List<UserPointStatus> myPointList = reviewService.selectPointStatusList(userId);		
		List<Review> reviews = reviewService.selectReview(placeId);
		map.put("review", reviews);
		map.put("myPoint", myPoint);
		map.put("status", myPointList);
		
		return map;
	}
}
