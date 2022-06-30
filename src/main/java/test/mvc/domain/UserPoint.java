package test.mvc.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.DynamicInsert;

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
public class UserPoint {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_point_seq")
	@SequenceGenerator(sequenceName = "user_point_seq", allocationSize = 1, name = "user_point_seq")
	private Long userPointId;
	
	@Column
	private int userPoint;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private Users users;
	
	@OneToMany(fetch = FetchType.LAZY,  mappedBy = "userPoint" , cascade = CascadeType.REMOVE  , orphanRemoval = true)
	@JsonIgnore
	private List<UserPointStatus> userPointStatus;
}
