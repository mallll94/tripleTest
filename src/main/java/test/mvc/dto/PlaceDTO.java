package test.mvc.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PlaceDTO {

	private String placeId;
	private String reviewCheck;
	private List<ReviewDTO> reviews;
	
}
