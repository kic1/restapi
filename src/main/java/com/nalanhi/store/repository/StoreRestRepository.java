package com.nalanhi.store.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.nalanhi.store.domain.Store;

@RepositoryRestResource(collectionResourceRel = "store", path = "stores")
public interface StoreRestRepository extends CrudRepository<Store, Long> {

}
