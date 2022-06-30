package test.mvc.domain;

import lombok.NoArgsConstructor;

import lombok.AllArgsConstructor;

import lombok.Getter;

import lombok.Setter;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Place {

	@Id
	private String placeId;
	
	@Column//0이면 최초 등록 1이면 기존 등록
	private String reviewCheck;
	
	@OneToMany(fetch = FetchType.LAZY,  mappedBy = "place" , cascade = CascadeType.REMOVE  , orphanRemoval = true)
	@JsonIgnore
	private List<Review> reviews;
	
}
