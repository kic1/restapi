package com.nalanhi.common.base.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nalanhi.common.util.string.UString;
import com.nalanhi.common.base.domain.Error;
import com.nalanhi.common.base.repository.ErrorRepository;

/**
 * 에러 service
 * @author jbeomh@gmail.com
 * @date 2018. 3. 30.
 *
 */
@Service
@Transactional
public class ErrorService {
	
	/** 등록 */
	public Error insert(String protocol, String method, String requesturi, String query, String header, String errorclass, String errorname, String remoteAddr, String errormessage) {
		// TEXT 65,535 초과시 에러발생
		errormessage = UString.cutStringByBytes(errormessage, 65000);
		Error error = new Error(null, protocol, method, requesturi, query, header, errorclass, errorname, errormessage);
		return errorRepository.save(error);
	}
	
	@Autowired private ErrorRepository errorRepository = null;
}
