package com.nalanhi.common.helper.context;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author       임정채
 * @since        2017.03.03
 * @description  REQUEST HELPER
 * @history      
 *       
 *  수정일                수정자              수정내용
 *  ----------   ---------   -------------------------------
 *  2017.02.28      임정채              최초생성	
 *****************************************************************************************************/
@Component
public class RequestHelper {
 
	
	public static HttpServletRequest getRequest(){
	
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	}
}




