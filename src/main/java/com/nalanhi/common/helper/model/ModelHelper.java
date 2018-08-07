package com.nalanhi.common.helper.model;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

/**
 * @author       임정채
 * @since        2017.01.23
 * @description  MODEL HELPER
 * @history      
 *       
 *  수정일                수정자              수정내용
 *  ----------   ---------   -------------------------------
 *  2017.02.01      임정채              최초생성	
 *****************************************************************************************************/
@Component
public class ModelHelper {
 
	
	/**
	 * STATIC 으로 접근 하기 위한 인스턴스 설정
	 * <br><br>
	 * 
	 * @param modelMapper 인스턴스
	 ********************************************************************************************/
	@Autowired 
	private ModelHelper(ModelMapper modelMapper) { 
		
		ModelHelper.modelMapper = modelMapper; 
	}
	
	/**
	 * 인스턴스 - 클래스 정보 매핑
	 * <br><br>
	 * 
	 * @param  o1  복사 주는 인스턴스
	 * @param  c2  복사 받는 클래스
	 * @return    복사 받은 인스턴스(생성 된)
	 ********************************************************************************************/
	@SuppressWarnings("unchecked")
	public static <T> T map(Object o1, Class<?> c2){
		
		return (T)modelMapper.map(o1, c2);
	}
	
	/**
	 * 인스턴스 - 인스턴스 정보 매핑
	 * <br><br>
	 * 
	 * @param  o1  복사 주는 인스턴스
	 * @param  o2  복사 받는 인스턴스
	 * @return    복사 받은 인스턴스(생성되어 있는)
	 ********************************************************************************************/
	@SuppressWarnings("unchecked")
	public static <T> T map(Object o1, Object o2){
		
		modelMapper.map(o1, o2);
		return (T)o2;
	}
	
	/**
	 * 페이징(목록) 정보 매핑
	 * <br><br>
	 * 
	 * @param  l1  페이지
	 * @param  c1  복사 받는 인스턴스
	 * @param  p1  페이지 기본 정보(페이징 관련 정보)
	 * @return    복사 받은 인스턴스(생성 된)
	 ********************************************************************************************/
	public static PageImpl<?> page(Page<?> l1, Class<?> c1, Pageable p1){
		
		List<?> resultList = l1.getContent().parallelStream()
					           .map(result -> (Object)modelMapper.map(result, c1))
					           .collect(Collectors.toList());
		
		return new PageImpl<>( resultList, p1, l1.getTotalElements() );
	}
	
	/**
	 * 목록 정보 매핑
	 * <br><br>
	 * 
	 * @param  l1  목록
	 * @param  c1  복사 받는 인스턴스
	 * @return    복사 받은 인스턴스(생성 된)
	 ********************************************************************************************/
	public static List<?> list(List<?> l1, Class<?> c1){
		
		return l1.parallelStream()
			     .map(result -> (Object)modelMapper.map(result, c1))
			     .collect(Collectors.toList());
	}
	
	private static ModelMapper modelMapper = null;
}
