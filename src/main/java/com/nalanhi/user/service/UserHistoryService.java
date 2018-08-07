package com.nalanhi.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.history.Revision;
import org.springframework.data.history.Revisions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nalanhi.common.exception.NoDataException;
import com.nalanhi.user.domain.User;
import com.nalanhi.user.repository.UserRepository;

/**
 * 회원 이력 service
 * @author jbeomh@gmail.com
 * @date 2018. 4. 11.
 *
 */
@Service
@Transactional
public class UserHistoryService {
	
	/** 최근 리비전 조회 */
	public User findLastChangeRevision(Long seq) {
		
		Revision<Integer, User> revisionResult = userRepository.findLastChangeRevision(seq);
		if(null == revisionResult) { throw new NoDataException(); }
		
		return revisionResult.getEntity();
	}
	
	/** 모든 히스토리 조회 */
	public List<User> findRevisions(Long seq) {
		
		Revisions<Integer, User> revisionResult = userRepository.findRevisions(seq);
		if(null == revisionResult) { throw new NoDataException(); }
		
		List<User> results = new ArrayList<User>();
		for(Revision<Integer, User> revision : revisionResult) { 
			User entity = revision.getEntity();
			entity.saveRevisionNumber(revision.getRevisionNumber());
			
			results.add(entity);
		}
		
		return results;
	}
	
	/** 히스토리를 페이징 + 정렬 조회 */
	public List<User> findRevisions(Long seq, Pageable pageable) {
		
		Page<Revision<Integer, User>> revisionResult = userRepository.findRevisions(seq, pageable);
		if(null == revisionResult) { throw new NoDataException(); }

		List<User> results = new ArrayList<User>();
		for(Revision<Integer, User> revision : revisionResult) {
			results.add(revision.getEntity());
		}
		
		return results;
	}
	
	/** 특정 리비전 조회 */
	public User findRevision(Long seq, Integer revisionNumber) {
		
		Revision<Integer, User> revisionResult = userRepository.findRevision(seq, revisionNumber);
		if(null == revisionResult) { throw new NoDataException(); }
		
		return revisionResult.getEntity();
	}
	
	/** 특정 리비전으로 원복 */
	public User restoreRevision(Long seq, Integer revisionNumber) {
		
		Revision<Integer, User> revisionResult = userRepository.findRevision(seq, revisionNumber);
		if(null == revisionResult) { throw new NoDataException(); }
		
		User revision = revisionResult.getEntity();
		
		User findUser = userRepository.findOne(seq);
		findUser.restoreUser(
				revision.getName(), revision.getUserState(), revision.getJoinType(), revision.getEmail(), revision.getJoinDt(),
				revision.getBirthDt(), revision.getGenderType(), revision.getTel(), revision.getSnsToken(), revision.getLeaveDt(), revision.getStoreSeq()
		);
		userRepository.save(findUser);
		
		return findUser;
	}
		
	@Autowired private UserRepository userRepository = null;
}
