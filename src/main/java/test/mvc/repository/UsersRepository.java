package test.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import test.mvc.domain.Users;

public interface UsersRepository extends JpaRepository<Users, String>, QuerydslPredicateExecutor<Users> {

}
