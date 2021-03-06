package test.mvc.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.DynamicInsert;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Users {

	@Id
	private String userId;
	
	@Column
	private String userName;
	
	@OneToOne(mappedBy = "users")
	@JsonIgnore
	private UserPoint userPoint;
	
	@OneToMany(fetch = FetchType.LAZY,  mappedBy = "users" , cascade = CascadeType.REMOVE  , orphanRemoval = true)
	@JsonIgnore
	private List<Review> review;
	
	@OneToMany(fetch = FetchType.LAZY,  mappedBy = "users" , cascade = CascadeType.REMOVE  , orphanRemoval = true)
	@JsonIgnore
	private List<UserPointStatus> userPointStatus;
}
