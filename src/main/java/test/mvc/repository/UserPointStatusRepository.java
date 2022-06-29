package test.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import test.mvc.domain.UserPointStatus;

public interface UserPointStatusRepository extends JpaRepository<UserPointStatus, Long>, QuerydslPredicateExecutor<UserPointStatus> {

}
