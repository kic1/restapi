package com.nalanhi.common.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nalanhi.common.base.domain.SecurityAuthority;
import com.nalanhi.common.base.repository.SecurityAuthorityRepository;

/**
 * @author jbeomh@gmail.com
 * @date 2018. 4. 19.
 * security authority service
 */
@Service
public class SecurityAuthorityService {
	
	public List<SecurityAuthority> selectAuthorityList(String username) {
		return securityAuthorityRepository.findAllByUsername(username);
	}
	
	@Autowired SecurityAuthorityRepository securityAuthorityRepository = null;
}
