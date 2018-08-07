package com.nalanhi.common.aop;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.nalanhi.common.exception.NoDataException;
import com.nalanhi.common.exception.SystemException;
import com.nalanhi.common.exception.UnAuthorizedException;
import com.nalanhi.common.exception.common.ExceptionResponse;
import com.nalanhi.common.base.service.ErrorService;

/**
 * @author jbeomh@gmail.com
 * @date 2017. 9. 19.
 * reference site : http://springboot.tistory.com/33
 *  response code : http://onecellboy.tistory.com/346
 */
@ControllerAdvice
public class ExceptionsHandler {
	
    /**
     * 일반적인 어플리케이션 예외(어플리케이션 예외 최상위)
     * @return 응답 정보(response status code : 400 잘못된요청)
     */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = SystemException.class)
    public ResponseEntity<?> handleSystemException(HttpServletRequest request, SystemException exception) {
		logging(request, exception, null, Exception.class);
		return new ResponseEntity<>(exception.getExceptionResponse(), HttpStatus.BAD_REQUEST);
	}
	
    /**
     * ExceptionCode : E00010002
     * @return 응답 정보(response status code : 204 컨텐츠 없음)
     */
	@ResponseStatus(HttpStatus.NO_CONTENT)
    @ExceptionHandler(value = NoDataException.class)
    public ResponseEntity<?> handleNoDataException(HttpServletRequest request, NoDataException exception) { 
		return new ResponseEntity<>(exception.getExceptionResponse(), HttpStatus.NO_CONTENT);
	}
    
    /**
     * ExceptionCode : E00010003
     * @return 응답 정보(response status code : 401 권한 없음)
     */
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = UnAuthorizedException.class)
    public ResponseEntity<?> handleUnAuthorizedException(HttpServletRequest request, UnAuthorizedException exception) { 
		logging(request, exception, exception.getExceptionResponse(), UnAuthorizedException.class);
		return new ResponseEntity<>(exception.getExceptionResponse(), HttpStatus.UNAUTHORIZED);
	}
	
    /** 
     * 에러로그 기록 (tb_error)
     */
    private void logging(HttpServletRequest request, Exception exception, ExceptionResponse exceptionResponse, Class<?> clazz) {
    	
		errorService.insert(
				request.getProtocol(), 
				request.getMethod(), 
				request.getRequestURI(), 
				request.getQueryString(), 
				getHeaderStr(request), 
				clazz.getName(), 
				exception.toString(), 
				request.getRemoteAddr(), 
				getErrorMessage(exception)
		);
    }
    
	/** 에러메시지 추출 */
	private String getErrorMessage(Exception exception) {
		
		StringWriter sw = new StringWriter();
        PrintWriter  pw = new PrintWriter(sw);
        exception.printStackTrace(pw);
        pw.flush();
		return sw.toString();
	}
	
	/** 헤더 정보를 String 으로 반환 */
	private String getHeaderStr(HttpServletRequest request) {
		
		Enumeration<?> headerNames = request.getHeaderNames();
    	StringBuffer headerStr = new StringBuffer();
    	
    	while(headerNames.hasMoreElements()) {
    		headerStr.append("{");
    		String name  = (String)headerNames.nextElement();
    		headerStr.append(name);
    		headerStr.append(":");
    		headerStr.append(request.getHeader(name));
    		headerStr.append("}");
    	}
		return headerStr.toString();
	}

	@Autowired private ErrorService errorService = null;
}
