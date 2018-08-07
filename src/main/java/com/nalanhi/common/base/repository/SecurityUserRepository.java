package com.nalanhi.common.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nalanhi.common.base.domain.SecurityUser;

/**
 * @author jbeomh@gmail.com
 * @date 2018. 4. 19.
 * security user table repository
 */
@Repository
public interface SecurityUserRepository extends JpaRepository<SecurityUser, String> {

}
