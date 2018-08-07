package com.nalanhi.common.helper.model;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author       임정채
 * @since        2017.02.27
 * @description  OBJECT HELPER
 * @history      
 *       
 *  수정일                수정자              수정내용
 *  ----------   ---------   -------------------------------
 *  2017.02.27      임정채              최초생성	
 *****************************************************************************************************/
@Component
public class ObjectHelper {
	
	/**
	 * STATIC 으로 접근 하기 위한 인스턴스 설정
	 * <br><br>
	 * 
	 * @param objectMapper 인스턴스
	 ********************************************************************************************/
	@Autowired 
	private ObjectHelper(ObjectMapper objectMapper) { 
		
		ObjectHelper.objectMapper = objectMapper; 
	}

	/**
	 * 파일의 JSON 문자열 반환
	 * <br><br>
	 * 
	 * @param  path  JSON 경로
	 * @return       JSON 문자열
	 ********************************************************************************************/
//	public static String getJsonForFile(String path){
//		
//		String absolutePath = PathHelper.getPath(PropertiesHelper.getTest().getPath() + path); 
//		
//		try 				     { return new JSONParser().parse(new FileReader(absolutePath)).toString(); } 
//		catch (IOException    e) { e.printStackTrace();                                                    }
//		catch (ParseException e) { e.printStackTrace();                                                    }
//		
//		return null;
//	}
	
	/**
	 * 인스턴스의 JSON 문자열 반환
	 * <br><br>
	 * 
	 * @param  o1  인스턴스
	 * @return    JSON 문자열
	 ********************************************************************************************/
	public static String getJsonForInstance(Object o1){
		
		try 							{ return objectMapper.writeValueAsString(o1); }
		catch(JsonProcessingException e){ e.printStackTrace(); 						  }
		
		return null; 
	}
	
	/**
	 * 파일의 인스턴스 반환
	 * <br><br>
	 * 
	 * @param  clazz 인스턴스
	 * @param  path  JSON 경로
	 * @return       Object
	 ********************************************************************************************/
//	@SuppressWarnings("unchecked")
//	public static <T> T getInstanceForFile(Class<?> clazz, String path){
//
//		try 			  	{ return (T)objectMapper.readValue(getJsonForFile(path), clazz); }
//		catch(IOException e){ e.printStackTrace(); 					                         }
//		
//		return null; 
//	}
	
	/**
	 * JSON 문자열의 인스턴스 반환
	 * <br><br>
	 * 
	 * @param  clazz 인스턴스
	 * @param  json  인스턴스
	 * @return       Object
	 ********************************************************************************************/
	@SuppressWarnings("unchecked")
	public static <T> T getInstanceForJson(Class<?> clazz, String json){

		try 			  	{ return (T)objectMapper.readValue(json, clazz); }
		catch(IOException e){ e.printStackTrace(); 					         }
		
		return null; 
	}
	
	private static ObjectMapper objectMapper = null;
}
