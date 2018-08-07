package com.nalanhi.common.exception;

import com.nalanhi.common.helper.message.MessageHelper;

import com.nalanhi.common.exception.common.ExceptionCode;
import com.nalanhi.common.exception.common.ExceptionResponse;

import lombok.Getter;
import lombok.Setter;

/**
 * @author jbeomh@gmail.com
 * @date 2017. 9. 19.
 * @description  권한이 없을 때 발생시킬 예외
 *
 */
@Setter
@Getter
@SuppressWarnings("serial")
public class UnAuthorizedException extends RuntimeException {
 
	/**
	 *      기본 예외 코드 설정(E00010003)
	 * <br> 잘못된 권한으로 요청하는 경우 발생하는 예외
	 * <br><br>
	 ********************************************************************************************/
	public UnAuthorizedException(){
		
		exceptionResponse.setCode   (ExceptionCode.E00010003);
		exceptionResponse.setMessage(MessageHelper.getMessage(ExceptionCode.E00010003)); 
	}
	
	/**
	 *      지정 예외 코드 설정
	 * <br> 잘못된 권한으로 요청하는 경우 발생하는 예외
	 * <br><br>
	 * 
	 * @param exceptionCode 예외 코드
	 ********************************************************************************************/
	public UnAuthorizedException(ExceptionCode exceptionCode){

		exceptionResponse.setCode   (exceptionCode);
		exceptionResponse.setMessage(MessageHelper.getMessage(exceptionCode)); 
	}
	
	private ExceptionResponse exceptionResponse = new ExceptionResponse();
}
