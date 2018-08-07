package com.nalanhi.user.predicate;

import java.util.List;

import com.nalanhi.user.domain.User;
import com.nalanhi.user.domain.UserForm;

public interface UserRepositoryPredicate {
	
	/** 목록 */
	public List<User> searchUsers(UserForm.SearchForm searchForm);
}
