package com.nalanhi.user.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nalanhi.common.exception.NoDataException;
import com.nalanhi.user.domain.User;
import com.nalanhi.user.repository.UserRepository;

/**
 * 회원 helper
 * @author jbeomh@gmail.com
 * @date 2018. 4. 16.
 *
 */
@Service
public class UserHelper {
	
	public User findOneBySeq(Long seq) {
		
		User findUser = userRepository.findOne(seq);
		if(null == findUser) { throw new NoDataException(); }
		
		return findUser;
	}
	
	@Autowired private UserRepository userRepository = null;
}
