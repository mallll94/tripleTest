package test.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import test.mvc.domain.Place;

public interface PlaceRepository extends JpaRepository<Place, String>, QuerydslPredicateExecutor<Place> {

}
