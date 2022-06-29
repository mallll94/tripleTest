package test.mvc.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import test.mvc.dto.ReviewDTO;
import test.mvc.service.ReviewService;

@RestController("/review")
@RequiredArgsConstructor
public class TestController {

	private final ReviewService reviewService;
	
	
	@RequestMapping("/event")
	public String review(String type,String action,String reviewId,String content,String [] attachedPhotoIds,String userId, String placeId) {
		ReviewDTO dto = new ReviewDTO(reviewId, content, attachedPhotoIds, userId, placeId);
		
		
		if(action.equals("ADD")) {
			reviewService.insertReview(dto);
		}else if(action.equals("MOD")) {
			reviewService.updateReview(dto);
		}else if(action.equals("DELETE")) {
			
		}
			
		
		return null;
	}
}
