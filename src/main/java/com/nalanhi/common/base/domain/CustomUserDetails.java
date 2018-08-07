package com.nalanhi.common.base.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.Getter;
import lombok.Setter;

/**
 * @author jbeomh@gmail.com
 * @date 2018. 4. 19.
 * UserDetails(I) 를 구현한 User(C) 외에 추가 데이터를 세팅하기 위해 시큐리티 User 를 상속 받음 
 */
@Getter
@Setter
public class CustomUserDetails extends org.springframework.security.core.userdetails.User {
	
	private static final long serialVersionUID = -4855890427225819382L;
	
	private Long   userSeq;
	private String userName;
	private String userEmail;
	private String userIp;
	
	public CustomUserDetails(SecurityUser user){
		
		super(
				user.getUsername(), user.getPassword(), user.isEnabled(), user.isAccountNonExpired(), 
				user.isCredentialsNonExpired(), user.isAccountNonLocked(), authorities(user)
		);
		
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		this.userSeq   = user.getUserSeq();
		this.userName  = user.getUser().getName();
		this.userEmail = user.getUser().getEmail();
		this.userIp    = request.getRemoteAddr();
	}
	
	private static Collection<? extends GrantedAuthority> authorities(SecurityUser user) {
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		user.getAuthoritys().forEach(a -> {
			authorities.add(new SimpleGrantedAuthority(a.getRoleId()));
		});
		return authorities;
	}
	
//	public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
//		super(username, password, authorities);
//	}
//	
//	public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities, String nickname) {
//		
//		super(username, password, authorities);
//		this.name = nickname;
//	}
//	
//	public CustomUserDetails(String username, String password, boolean enabled, boolean accountNonExpired,
//			boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
//		
//		super(username, password, authorities);
//	}
}
