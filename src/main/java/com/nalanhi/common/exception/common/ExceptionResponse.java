package com.nalanhi.common.exception.common;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

/**
 * @author jbeomh@gmail.com
 * @date 2017. 9. 19.
 *
 */
@Setter
@Getter
public class ExceptionResponse {
 
	private ExceptionCode             code      = null;
	private String                    message   = null;
	private List<Map<String, String>> errorList = null; 
}