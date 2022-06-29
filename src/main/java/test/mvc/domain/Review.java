package test.mvc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Review {

	@Id
	private String reviewId;
	
	@Column
	private String content;
	
	@Column
	private String attachedPhotoIds;
	
	@ManyToOne
	@JoinColumn(name = "place_fk")
	private Place place;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private Users users;
}
