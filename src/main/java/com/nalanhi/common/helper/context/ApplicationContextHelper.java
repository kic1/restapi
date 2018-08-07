package com.nalanhi.common.helper.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author       임정채
 * @since        2017.02.28
 * @description  APPLICATON CONTEXT HELPER
 * @history      
 *       
 *  수정일                수정자              수정내용
 *  ----------   ---------   -------------------------------
 *  2017.02.28      임정채              최초생성	
 *****************************************************************************************************/
@Component
public class ApplicationContextHelper {
 
	
	/**
	 * STATIC 으로 접근 하기 위한 인스턴스 설정
	 * <br><br>
	 * 
	 * @param modelMapper 인스턴스
	 ********************************************************************************************/
	@Autowired 
	private ApplicationContextHelper(ApplicationContext applicationContext) { 
		
		ApplicationContextHelper.applicationContext = applicationContext; 
	}
	
	/**
	 * 인스턴스 반환
	 * <br><br>
	 * 
	 * @param  clazz 주입 될 클래스
	 * @return       인스턴스
	 ********************************************************************************************/
	@SuppressWarnings("unchecked")
	public static <T> T getInstance(Class<?> clazz){
		
		return (T)applicationContext.getBean(clazz);
	}
	
	
	private static ApplicationContext applicationContext = null;
}




