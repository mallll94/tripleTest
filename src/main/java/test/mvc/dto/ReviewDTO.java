package test.mvc.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {


	private String reviewId;
	private String content;
	private String [] attachedPhotoIds;
	private String userId;
	private String placeId;

}
