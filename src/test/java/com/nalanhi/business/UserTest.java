package com.nalanhi.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.nalanhi.common.helper.model.ModelHelper;
import com.nalanhi.user.domain.User;
import com.nalanhi.user.domain.UserForm;
import com.nalanhi.user.enumeration.GenderType;
import com.nalanhi.user.enumeration.JoinType;
import com.nalanhi.user.repository.UserRepository;
import com.nalanhi.user.service.UserService;

/**
 * @author beomhoon.jeong@vtw.co.kr
 * @date 2018. 4. 10.
 * EnversTest
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional
public class UserTest {
	
	@Autowired private UserRepository userRepository = null;
	@Autowired private UserService userService = null;
	
	@Test
	public void t1_testRepository() {
		
		// 등록
		String name1    = "테스터";
		String birthDt1 = "20000101";
		User   user     = new User(name1, JoinType.FACEBOOK, "test@naver.com", birthDt1, GenderType.MAN, "01098653265", "snsToken");
		userRepository.save(user);
		
		User findUser1 = userRepository.findOne(user.getSeq());
		assertNotNull(findUser1);
		assertEquals (name1,    findUser1.getName());
		assertEquals (birthDt1, findUser1.getBirthDt());
		
		// 수정
		Long   seq2      = user.getSeq();
		User   findUser2 = userRepository.findOne(seq2);
		String birthDt2  = "19990606";
		
		findUser2.saveBirthDt(seq2, birthDt2);
		userRepository.save(findUser2);
		assertEquals(birthDt2, findUser2.getBirthDt());
		
		// 재 수정
		Long   seq3      = new Long(3);
		User   findUser3 = userRepository.findOne(seq3);
		String birthDt3  = "19820218";
		
		findUser3.saveBirthDt(seq3, birthDt3);
		userRepository.save(findUser3);
		assertEquals(birthDt3, findUser3.getBirthDt());
	}
	
	@Test
	public void t2_testService() {
		
		// 등록
		String birthDt1 = "20000101";
		User user = new User("테스터", JoinType.FACEBOOK, "test@naver.com", birthDt1, GenderType.MAN, "01098653265", "snsToken");
		UserForm.InsertForm form = ModelHelper.map(user, UserForm.InsertForm.class);
		User responseUser = userService.insert(form);
		assertNotNull(responseUser);
		assertEquals (birthDt1, responseUser.getBirthDt());
		
		// 수정
		Long   seq2      = responseUser.getSeq();
		User   findUser2 = userService.select(seq2);
		String birthDt2  = "19990606";
		
		findUser2.saveBirthDt(seq2, birthDt2);
		assertEquals(birthDt2, findUser2.getBirthDt());
		
		// 재 수정
		Long   seq3      = new Long(3);
		User   findUser3 = userService.select(seq3);
		String birthDt3  = "19820218";
		
		findUser3.saveBirthDt(seq3, birthDt3);
		assertEquals(birthDt3, findUser3.getBirthDt());
	}
}
