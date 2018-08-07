package com.nalanhi.common.config.envers;

import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author jbeomh@gmail.com
 * @date 2018. 4. 10.
 * Auditing 감사(감독하고 검사함)기능 설정
 * http://haviyj.tistory.com/40
 */
@Configuration
@EnableJpaAuditing
public class JpaAuditingConfiguration {
	
	@Bean
	public AuditorAware<Long> auditorProvider() {
		// httpsession
//		return () -> session().getUserId();
		// spring security
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication == null || !authentication.isAuthenticated()) {
//            return null;
//        }
//        return ((User) authentication.getPrincipal()).getUsername();
		// test code
		return () -> getRandomNumber();
	}
	
	public static long getRandomNumber(){
		
	    Random random = new Random();
	    return random.nextLong() % (9999999999L - 1000000000L) + 9999999999L;
	}
}
