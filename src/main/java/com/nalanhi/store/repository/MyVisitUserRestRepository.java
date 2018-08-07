package com.nalanhi.store.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.nalanhi.store.domain.MyVisitUser;

@RepositoryRestResource(collectionResourceRel = "myVisitUser", path = "myvisitusers")
public interface MyVisitUserRestRepository extends CrudRepository<MyVisitUser, Long> {

}
