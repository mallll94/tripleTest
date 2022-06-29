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

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Place {

	@Id
	private String placeId;
	
	@Column
	private int reviewCheck;
	
	@OneToMany(fetch = FetchType.LAZY,  mappedBy = "place" , cascade = CascadeType.REMOVE  , orphanRemoval = true)
	private List<Review> reviews;
	
}
