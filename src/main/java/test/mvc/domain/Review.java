package test.mvc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@JsonIgnore
	private Place place;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private Users users;
}
