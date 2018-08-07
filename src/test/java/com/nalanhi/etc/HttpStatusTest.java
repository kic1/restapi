package com.nalanhi.etc;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author beomhoon.jeong@vtw.co.kr
 * @date 2018. 4. 13.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional
public class HttpStatusTest {
	
	@Before
    public void setup() {
		System.out.println("============================================");
	}
	
	@Test
	public void t1_getValue() {
		System.out.println(HttpStatus.BAD_REQUEST); // 400
		System.out.println(HttpStatus.BAD_REQUEST.name()); // BAD_REQUEST
		System.out.println(HttpStatus.BAD_REQUEST.toString()); // 400
		System.out.println(HttpStatus.BAD_REQUEST.value()); // 400
	}
	
	@Test
	public void t2_getType() {
		System.out.println(HttpStatus.OK); // 200
		System.out.println(HttpStatus.CREATED); // 201
		System.out.println(HttpStatus.NO_CONTENT); // 204
		System.out.println(HttpStatus.BAD_REQUEST); // 400
		System.out.println(HttpStatus.UNAUTHORIZED); // 401
		System.out.println(HttpStatus.NOT_FOUND); // 404
		System.out.println(HttpStatus.INTERNAL_SERVER_ERROR); // 500
		System.out.println(HttpStatus.SERVICE_UNAVAILABLE); // 503
	}
}
