package test.mvc.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserPoint {

	@Id
	private Long userPointId;
	
	@Column
	private int userPoint;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private Users users;
	
	@OneToMany(fetch = FetchType.LAZY,  mappedBy = "userPoint" , cascade = CascadeType.REMOVE  , orphanRemoval = true)
	private List<UserPointStatus> userPointStatus;
}
