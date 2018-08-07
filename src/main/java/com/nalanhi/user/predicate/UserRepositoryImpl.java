package com.nalanhi.user.predicate;

import java.util.List;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import com.nalanhi.common.util.string.UString;
import com.nalanhi.user.domain.QUser;
import com.nalanhi.user.domain.User;
import com.nalanhi.user.domain.UserForm;
import com.querydsl.jpa.JPQLQuery;

public class UserRepositoryImpl extends QueryDslRepositorySupport implements UserRepositoryPredicate {
	
	public List<User> searchUsers(UserForm.SearchForm searchForm) {
		
		JPQLQuery<User> query = from(qUser);
		if(true == UString.isNotNull(searchForm.getSearchUserState ())) { query.where( qUser.userState.eq(searchForm.getSearchUserState ())); }
		if(true == UString.isNotNull(searchForm.getSearchJoinType  ())) { query.where(  qUser.joinType.eq(searchForm.getSearchJoinType  ())); }
		if(true == UString.isNotNull(searchForm.getSearchJoinDt    ())) { query.where(    qUser.joinDt.eq(searchForm.getSearchJoinDt    ())); }
		if(true == UString.isNotNull(searchForm.getSearchBirthDt   ())) { query.where(   qUser.birthDt.eq(searchForm.getSearchBirthDt   ())); }
		if(true == UString.isNotNull(searchForm.getSearchGenderType())) { query.where(qUser.genderType.eq(searchForm.getSearchGenderType())); }
		
		List<User> result = query.fetch();
		return 0 < result.size() ? result : null;
	}
	
	public UserRepositoryImpl() {
		super(User.class);
	}
	
	private QUser qUser = QUser.user;
}
