package com.nalanhi.common.config.model;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 

/**
 * @author       임정채
 * @since        2017.01.11
 * @description  MODEL MAPPER CONFIG
 * 				 reference site : http://modelmapper.org/user-manual/configuration/#matching-strategies
 * @history      
 * 
 *       
 *  수정일                수정자              수정내용
 *  ----------   ---------   -------------------------------
 *  2017.02.01      임정채              최초생성	
 *  2017.02.20   임정채               ModelMapper 매칭 전략 수정
 *****************************************************************************************************/
@Configuration
public class ModelMapperConfiguration {
 
	/**
	 * MODEL MAPPER
	 * <br><br>
	 * 
	 * @return MODEL MAPPER INSTANCE
	 ********************************************************************************************/
	@Bean
	public ModelMapper modelMapper(){
		
		ModelMapper modelMapper = new ModelMapper();
		//modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		return modelMapper;
	}
}