package com.nalanhi.common.base.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nalanhi.common.base.domain.SecurityUser;
import com.nalanhi.common.base.repository.SecurityUserRepository;

/**
 * @author jbeomh@gmail.com
 * @date 2018. 4. 19.
 * security user service
 */
@Service
public class SecurityUserService {
	
	public SecurityUser selectUser(String username) {
		return securityUserRepository.findOne(username);
	}
	
	@Autowired SecurityUserRepository securityUserRepository = null;
}
