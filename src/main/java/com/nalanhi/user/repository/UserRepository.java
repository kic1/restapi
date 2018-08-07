package com.nalanhi.user.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

import com.nalanhi.user.domain.User;
import com.nalanhi.user.enumeration.UserState;
import com.nalanhi.user.predicate.UserRepositoryPredicate;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, RevisionRepository<User, Long, Integer>, UserRepositoryPredicate {
	
	// 상태값, 페이징 정보에 맞는 User 조회
	Page<User> findAllByUserState(UserState userState, Pageable pageable);
}
