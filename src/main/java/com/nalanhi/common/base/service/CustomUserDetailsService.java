package com.nalanhi.common.base.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nalanhi.common.base.domain.CustomUserDetails;
import com.nalanhi.common.base.domain.SecurityUser;

@Service
public class CustomUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		// user 조회
		SecurityUser user = securityUserService.selectUser(username);	
		if(null == user) { throw new UsernameNotFoundException(username); }
		
		// user 권한 조회
		user.setAuthoritys(securityAuthorityService.selectAuthorityList(username));
		
		CustomUserDetails userDetails = new CustomUserDetails(user);
		return userDetails;
	}
	
	@Autowired private SecurityAuthorityService securityAuthorityService;
	@Autowired private SecurityUserService      securityUserService;
}
