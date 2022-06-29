package test.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import test.mvc.domain.UserPoint;

public interface UserPointRepository extends JpaRepository<UserPoint, Long>, QuerydslPredicateExecutor<UserPoint> {

}
