package com.nalanhi.common.helper.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

import com.nalanhi.common.definition.message.Messages;
import com.nalanhi.common.exception.common.ExceptionCode;

/**
 * @author jbeomh@gmail.com
 * @date 2017. 8. 29.
 *
 */
@Component
public class MessageHelper {
	
	/**
	 * STATIC 으로 접근 하기 위한 메세지 인스턴스 설정
	 * <br><br>
	 * 
	 * @param messageSourceAccessor 메세지 인스턴스
	 ********************************************************************************************/
	@Autowired 
	private MessageHelper(MessageSourceAccessor messageSourceAccessor) { 
		
		MessageHelper.accessor = messageSourceAccessor; 
	}
	
	/**
	 * 메세지 반환
	 * <br><br>
	 * 
	 * @param code message_xx.properties 코드 메세지
	 ********************************************************************************************/
	public static String getMessage(String code){
		
		return accessor.getMessage(code);
	}
	
	/**
	 * 메세지 반환
	 * <br><br>
	 * 
	 * @param code message_xx.properties 코드 메세지
	 ********************************************************************************************/
	public static String getMessage(String code, Object[] args){
		
		return accessor.getMessage(code, args);
	}
	
	/**
	 * 메세지 반환
	 * <br><br>
	 * 
	 * @param code 예외 코드
	 ********************************************************************************************/
	public static String getMessage(Messages message){
		
		return accessor.getMessage(message.name());
	}
	
	/**
	 * 메세지 반환
	 * <br><br>
	 * 
	 * @param exceptionCode 예외 코드
	 ********************************************************************************************/
	public static String getMessage(ExceptionCode exceptionCode) {
		
		return accessor.getMessage(exceptionCode.name());
	}
	
	private static MessageSourceAccessor accessor = null;
}
