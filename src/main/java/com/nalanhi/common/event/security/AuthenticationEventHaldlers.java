package com.nalanhi.common.event.security;

import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

/**
 * @author jbeomh@gmail.com
 * @date 2018. 4. 18.
 * security event listener
 */
@Component
public class AuthenticationEventHaldlers {
	
	@EventListener
	public void handleBadCredential(AuthenticationFailureBadCredentialsEvent event) {
		System.out.println(event.getAuthentication().getPrincipal() + " 인증 시도중...");
		System.out.println("인증실패");
	}
	
	// handle etc event
	// https://docs.spring.io/spring-security/site/docs/4.2.4.RELEASE/apidocs/org/springframework/security/authentication/event/package-summary.html
	
}
