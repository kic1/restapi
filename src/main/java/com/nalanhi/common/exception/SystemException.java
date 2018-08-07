package com.nalanhi.common.exception;

import com.nalanhi.common.exception.common.ExceptionCode;
import com.nalanhi.common.exception.common.ExceptionResponse;
import com.nalanhi.common.helper.message.MessageHelper;

import lombok.Getter;
import lombok.Setter;

/**
 * @author       임정채
 * @since        2017.01.11
 * @description  일반적인 어플리케이션 예외(어플리케이션 예외 최상위)
 * @history      
 *       
 *  수정일                수정자              수정내용
 *  ----------   ---------   -------------------------------
 *  2017.02.01      임정채              최초생성	
 *****************************************************************************************************/
@Setter
@Getter
@SuppressWarnings("serial")
public class SystemException extends RuntimeException {
 
	/**
	 *      기본 예외 코드 설정(E00010001)
	 * <br> 일반적인 어플리케이션 예외(어플리케이션 예외 최상위)
	 * <br><br>
	 ********************************************************************************************/
	public SystemException(){

		exceptionResponse.setCode   (ExceptionCode.E00010001);
		exceptionResponse.setMessage(MessageHelper.getMessage(ExceptionCode.E00010001)); 
	}
	
	/**
	 *      지정 예외 코드 설정
	 * <br> 일반적인 어플리케이션 예외(어플리케이션 예외 최상위)
	 * <br><br>
	 * 
	 * @param exceptionCode 예외 코드
	 ********************************************************************************************/
	public SystemException(ExceptionCode exceptionCode){

		exceptionResponse.setCode   (exceptionCode);
		exceptionResponse.setMessage(MessageHelper.getMessage(exceptionCode)); 
	}
	
	
	private ExceptionResponse exceptionResponse = new ExceptionResponse();
}



