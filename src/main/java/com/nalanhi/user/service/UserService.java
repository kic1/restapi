package com.nalanhi.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nalanhi.common.exception.NoDataException;
import com.nalanhi.user.domain.User;
import com.nalanhi.user.domain.UserForm;
import com.nalanhi.user.enumeration.UserState;
import com.nalanhi.user.helper.UserHelper;
import com.nalanhi.user.repository.UserRepository;

/**
 * 회원 service
 * @author jbeomh@gmail.com
 * @date 2018. 3. 30.
 *
 */
@Service
@Transactional
public class UserService {
	
	/** 회원 검색 */
	public List<User> searchList(UserForm.SearchForm form) {
		
		List<User> list = userRepository.searchUsers(form);
		if(null == list) { throw new NoDataException(); }
		
		return list;
	}
	
	/** 회원 목록 */
	public Page<User> selectList(Pageable pageable){
		
		Page<User> list = userRepository.findAllByUserState(UserState.JOINED, pageable);
		if(null == list) { throw new NoDataException(); }
		
		return list;
	}
	
	/** 회원 조회 */
	public User select(Long seq) {
		
		User findUser = userHelper.findOneBySeq(seq);
		
		return findUser;
	}
	
	/** 회원 등록 */
	public User insert(UserForm.InsertForm form) {
		
		User user = new User(form.getName(), form.getJoinType(), form.getEmail(), form.getBirthDt(), form.getGenderType(), form.getTel(), form.getSnsToken());
		
		return userRepository.save(user);
	}
	
	/** 회원 수정 */
	public User update(UserForm.UpdateForm form, Long seq) {
		
		User findUser = userHelper.findOneBySeq(seq);
		findUser.updateUser(form.getName(), form.getEmail(), form.getBirthDt(), form.getGenderType(), form.getTel());
		
		return findUser;
	}

	/** 생일 수정 */
	public User updateBirthDt(UserForm.UpdateBirthDtForm form, Long seq) {
		
		User findUser = userHelper.findOneBySeq(seq);
		findUser.saveBirthDt(seq, form.getBirthDt());
		
		return findUser;
	}
	
	/** 회원 삭제 */
	public User delete(Long seq) {
		
		User findUser = userHelper.findOneBySeq(seq);
		findUser.deleteUser(seq);
		
		return findUser;
	}
	
	@Autowired private UserHelper     userHelper     = null;
	@Autowired private UserRepository userRepository = null;
}
