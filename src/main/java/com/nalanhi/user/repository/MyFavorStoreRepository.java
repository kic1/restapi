package com.nalanhi.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nalanhi.user.domain.MyFavorStore;

@Repository
public interface MyFavorStoreRepository extends JpaRepository<MyFavorStore, Long> {

}
