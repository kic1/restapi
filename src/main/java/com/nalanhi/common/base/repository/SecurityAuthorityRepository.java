package com.nalanhi.common.base.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nalanhi.common.base.domain.SecurityAuthority;

/**
 * @author jbeomh@gmail.com
 * @date 2018. 4. 19.
 * security authority table repository
 */
@Repository
public interface SecurityAuthorityRepository extends JpaRepository<SecurityAuthority, Long> {
	
	List<SecurityAuthority> findAllByUsername(String username);
}
