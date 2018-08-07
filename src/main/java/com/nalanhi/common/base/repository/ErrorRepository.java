package com.nalanhi.common.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nalanhi.common.base.domain.Error;

@Repository
public interface ErrorRepository extends JpaRepository<Error, Long> {

}
