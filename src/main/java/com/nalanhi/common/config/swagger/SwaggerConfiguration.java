package com.nalanhi.common.config.swagger;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author jbeomh@gmail.com
 * @date 2018. 3. 30.
 * http://lng1982.tistory.com/314
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	@Bean
	public Docket swagger() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				                           .select ()
				                           .apis   (RequestHandlerSelectors.any()) // RequestMapping으로 할당 된 모든 URL 목록
				                           .paths  (PathSelectors.ant("/api/**")) // 그중 /api/** 인 URL들만 필터링
				                           .build  ()
				                           .useDefaultResponseMessages(false) // Response Messages 제거
				                           .globalResponseMessage(RequestMethod.GET,    responseMessages) // 전체적인 Response Messages 설정 
				                           .globalResponseMessage(RequestMethod.POST,   responseMessages)
				                           .globalResponseMessage(RequestMethod.DELETE, responseMessages)
				                           .globalResponseMessage(RequestMethod.PUT,    responseMessages)
				                           .globalResponseMessage(RequestMethod.PATCH,  responseMessages)
				                           .apiInfo(metaData());
	}
    
	private ApiInfo metaData() {
        return new ApiInfoBuilder().title("nalanhi API specification")
        		                   .version("0.1.0")
                                   .build();
    }
	
	List<ResponseMessage> responseMessages = Arrays.asList(
		new ResponseMessageBuilder().code(          HttpStatus.OK.value()).message(          HttpStatus.OK.getReasonPhrase()).build(), // 200
		new ResponseMessageBuilder().code(  HttpStatus.NO_CONTENT.value()).message(  HttpStatus.NO_CONTENT.getReasonPhrase()).build(), // 204
		new ResponseMessageBuilder().code( HttpStatus.BAD_REQUEST.value()).message( HttpStatus.BAD_REQUEST.getReasonPhrase()).build(), // 400
		new ResponseMessageBuilder().code(HttpStatus.UNAUTHORIZED.value()).message(HttpStatus.UNAUTHORIZED.getReasonPhrase()).build()  // 401
    );
}
