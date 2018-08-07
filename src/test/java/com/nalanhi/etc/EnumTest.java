package com.nalanhi.etc;

import static java.util.stream.Collectors.joining;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.transaction.annotation.Transactional;

import com.nalanhi.helpdesk.enumeration.QuestionState;
import com.nalanhi.helpdesk.enumeration.QuestionType;

/**
 * @author beomhoon.jeong@vtw.co.kr
 * @date 2018. 4. 4.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional
public class EnumTest {
	
	private String result = null;
	public void   setResult(String str) { this.result = str;  }
	public String getResult()           { return this.result; }
	
	@Before
    public void setup() {
		System.out.println("============================================");
	}	
	
	@Test
	public void t1_getEnum() {
		for(Fruit f : Fruit.values()) {
			setResult(f.toString());
			System.out.println(getResult());
		}
		for(Company c : Company.values()) {
			setResult(c.getCompanyName());
			System.out.println(getResult());
		}
	}
	
	List<?> classlist = Arrays.asList(
			QuestionType.class,
			UserState.class
	);
	
	@Test
	public void t2_api() {
//		for(Object clazz : classlist) {
//			System.out.println(clazz);
//			System.out.println(clazz.toString());
//		}
		System.out.println(QuestionState.class.toString());
		String result = getEnumValues();
		System.out.println(result);
	}
	
	private String getEnumValues() {
		
		List<String> arrays = new ArrayList<String>();
		for(QuestionState c : QuestionState.values()) {
			arrays.add(c.toString());
		}
		return arrays.stream().collect(joining("','", "{'", "'}"));
	}
}

enum Fruit {
	APPLE, PEACH, BANANA;
}

enum Company {
	APPLE("애플"), FACEBOOK("페이스북"),  GOOGLE("구글");
	private String companyName;
	Company(String name) {this.companyName = name;}
	public  String getCompanyName() { return this.companyName; }
}
