package com.nalanhi.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nalanhi.user.domain.MyVisitStore;

@Repository
public interface MyVisitStoreRepository extends JpaRepository<MyVisitStore, Long> {

}
