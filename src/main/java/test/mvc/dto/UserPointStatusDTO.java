package test.mvc.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserPointStatusDTO {

	private Long userPointStateId;
	private UsersDTO users;
	private UserPointDTO userPoint;
	private String status;
	
}
