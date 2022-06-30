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
public class UserPointDTO {

	private Long userPointId;
	private int userPoint;
	private UsersDTO users;
	private List<UserPointStatusDTO> userPointStatus;
}
