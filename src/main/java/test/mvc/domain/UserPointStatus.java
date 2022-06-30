package test.mvc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
public class UserPointStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_point_status_seq")
	@SequenceGenerator(sequenceName = "user_point_status_seq", allocationSize = 1, name = "user_point_status_seq")
	private Long userPointStateId;
	
	@ManyToOne
	@JoinColumn(name = "users_fk")
	@JsonIgnore
	private Users users;
	
	@ManyToOne
	@JoinColumn(name = "userPoint_fk")
	@JsonIgnore
	private UserPoint userPoint;
	
	@Column
	private String status;
	
}
