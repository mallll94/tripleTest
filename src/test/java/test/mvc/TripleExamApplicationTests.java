package test.mvc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import test.mvc.domain.Place;
import test.mvc.domain.UserPoint;
import test.mvc.domain.Users;
import test.mvc.dto.ReviewDTO;
import test.mvc.repository.PlaceRepository;
import test.mvc.repository.ReviewRepository;
import test.mvc.repository.UserPointRepository;
import test.mvc.repository.UserPointStatusRepository;
import test.mvc.repository.UsersRepository;
import test.mvc.service.ReviewService;

@SpringBootTest
@Commit
class TripleExamApplicationTests {
	
	@Autowired
	private UsersRepository usersRep;
	
	@Autowired
	private PlaceRepository placeRep;
	
	@Autowired
	private UserPointRepository userPointRep;
	
	@Autowired
	private UserPointStatusRepository pointStatusRep;
	
	@Autowired
	private ReviewRepository reviewRep;
	
	@Autowired
	private ReviewService reviewService;
	
	@Test
	void contextLoads() {
		//usersRep.save(new Users("3ede0ef2-92b7-4817-a5f3-0c575361f744", "나야2", null, null, null));
		//placeRep.save(new Place("2e4baf1c-5acb-4efb-a1af-eddada31uuuu", null, null));
		//Users users = usersRep.findById("3ede0ef2-92b7-4817-a5f3-0c575361f744").orElse(null);
		//if(users==null) {
			//System.out.println("없다");
		//}
		//System.out.println("아이디"+users.getUserId());
		//userPointRep.save(new UserPoint(null, 0, users, null));
		//String [] attachedPhotoIds={"e4d1a64e-a531-46de-88d0-ff0ed70c0bb8","afb0cef2-851d-4a50-bb07-9cc15cbdc332"};
		//ReviewDTO dto = new ReviewDTO("240a0658-dc5f-4878-9381-ebb7b26671234", "좋아요!", attachedPhotoIds, "3ede0ef2-92b7-4817-a5f3-0c575361f745", "2e4baf1c-5acb-4efb-a1af-eddada31uuuu");
		//reviewService.updateReview(dto);
		//reviewService.insertReview(dto);
		//reviewService.deleteReview(dto);
		//reviewService.selectReview("2e4baf1c-5acb-4efb-a1af-eddada31uuuu");
	}
	
	
	@Test
	void useridInsert() {
		usersRep.save(new Users("3ede0ef2-92b7-4817-a5f3-0c575361f744", "나야2", null, null, null));
		Users users = usersRep.findById("3ede0ef2-92b7-4817-a5f3-0c575361f744").orElse(null);
		userPointRep.save(new UserPoint(null, 0, users, null));
	}

}
