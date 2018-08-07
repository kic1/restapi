package com.nalanhi.user.domain;

import com.nalanhi.user.enumeration.GenderType;
import com.nalanhi.user.enumeration.JoinType;
import com.nalanhi.user.enumeration.UserState;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 회원 form
 * @author jbeomh@gmail.com
 * @date 2018. 3. 30.
 *
 */
public class UserForm {
	
	@Getter
	@Setter
	@ApiModel(value="UserForm.SearchForm")
	public static class SearchForm {
		@ApiModelProperty(notes="회원 상태")
		private UserState  searchUserState = null;
		@ApiModelProperty(notes="회원 가입유형")
		private JoinType   searchJoinType = null;
		@ApiModelProperty(notes="가입일", example="20180416")
		private String     searchJoinDt = null;
		@ApiModelProperty(notes="생일", example="19850601")
		private String     searchBirthDt = null;
		@ApiModelProperty(notes="성별")
		private GenderType searchGenderType = null;
	}
	
	@Getter
	@Setter
	@ApiModel(value="UserForm.ListForm")
	public static class ListForm {
		@ApiModelProperty(notes="회원번호")
		private Long       seq = null; 
		@ApiModelProperty(notes="성명")
		private String     name = null;
		@ApiModelProperty(notes="회원 상태")
		private UserState  userState = null; 
		@ApiModelProperty(notes="회원 가입유형")
		private JoinType   joinType = null;
		@ApiModelProperty(notes="이메일")
		private String     email = null;
		@ApiModelProperty(notes="가입일")
		private String     joinDt = null;
		@ApiModelProperty(notes="생일")
		private String     birthDt = null;
		@ApiModelProperty(notes="성별")
		private GenderType genderType = null;
		@ApiModelProperty(notes="전화번호")
		private String     tel = null;
		@ApiModelProperty(notes="SNS 회원 가입 토큰")
		private String     snsToken = null;
	}
	
	@Getter
	@Setter
	@ApiModel(value="UserForm.InsertForm")
	public static class InsertForm {
		@ApiModelProperty(notes="성명", required=true, example="홍길동")
		private String     name = null;
		@ApiModelProperty(notes="회원 가입유형")
		private JoinType   joinType = null;
		@ApiModelProperty(notes="이메일", example="test@gmail.com")
		private String     email = null;
		@ApiModelProperty(notes="생일", required=true, example="19850601") 
		private String     birthDt = null; 
		@ApiModelProperty(notes="성별", required=true)
		private GenderType genderType = null; 
		@ApiModelProperty(notes="전화번호", example="01022223333")
		private String     tel = null; 
		@ApiModelProperty(notes="SNS 회원 가입 토큰", example="SNSTOKEN%GENERATEDBYSNS")
		private String     snsToken = null; 
	}
	
	@Getter
	@Setter
	@ApiModel(value="UserForm.UpdateForm")
	public static class UpdateForm {
		@ApiModelProperty(notes="성명", example="홍길동")
		private String     name = null;
		@ApiModelProperty(notes="이메일", example="test@gmail.com")
		private String     email = null;
		@ApiModelProperty(notes="생일", example="19850601")
		private String     birthDt = null;
		@ApiModelProperty(notes="성별")
		private GenderType genderType = null;
		@ApiModelProperty(notes="전화번호", example="01022223333")
		private String     tel = null;
	}
	
	@Getter
	@Setter
	@ApiModel(value="UserForm.UpdateBirthDtForm")
	public static class UpdateBirthDtForm {
		@ApiModelProperty(notes="생일", example="19850601")
		private String birthDt = null;
	}
	
	@Getter
	@Setter
	@ApiModel(value="UserForm.ResponseForm")
	public static class ResponseForm {
		@ApiModelProperty(notes="회원번호")
		private Long       seq = null;
		@ApiModelProperty(notes="성명")
		private String     name = null;
		@ApiModelProperty(notes="회원 상태")
		private UserState  userState = null;
		@ApiModelProperty(notes="회원 가입유형")
		private JoinType   joinType = null;
		@ApiModelProperty(notes="이메일")
		private String     email = null;
		@ApiModelProperty(notes="가입일")
		private String     joinDt = null;
		@ApiModelProperty(notes="생일")
		private String     birthDt = null;
		@ApiModelProperty(notes="성별")
		private GenderType genderType = null;
		@ApiModelProperty(notes="전화번호")
		private String     tel = null;
		@ApiModelProperty(notes="SNS 회원 가입 토큰")
		private String     snsToken = null;
		@ApiModelProperty(notes="탈퇴일")
		private String     leaveDt = null;
		@ApiModelProperty(notes="상점번호")
		private Long       storeSeq = null;
		
		/** 순환참조 해결 http://binarycube.tistory.com/1 */
//		@JsonBackReference
//		private List<Ticket> myWaitingStores = Lists.newArrayList();
	}
}
