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
public class UserHistoryForm {
	
	@Getter
	@Setter
	@ApiModel(value="UserHistoryForm.HistoryForm")
	public static class HistoryForm {
		@ApiModelProperty(notes = "회원번호")
		private Long       seq = null;
		@ApiModelProperty(notes = "리비전 번호")
		private Integer    rev = null;
		@ApiModelProperty(notes = "리비전 종류 (0:등록, 1:수정, 2:삭제)")
		private Integer    revtype = null;
		@ApiModelProperty(notes = "성명")
		private String     name = null;
		@ApiModelProperty(notes = "회원 상태")
		private UserState  userState = null;
		@ApiModelProperty(notes = "회원 가입유형")
		private JoinType   joinType = null;
		@ApiModelProperty(notes = "이메일")
		private String     email = null;
		@ApiModelProperty(notes = "가입일")
		private String     joinDt = null;
		@ApiModelProperty(notes = "생일")
		private String     birthDt = null;
		@ApiModelProperty(notes = "성별")
		private GenderType genderType = null;
		@ApiModelProperty(notes = "전화번호")
		private String     tel = null;
		@ApiModelProperty(notes = "SNS 회원 가입 토큰")
		private String     snsToken = null;
		@ApiModelProperty(notes = "탈퇴일")
		private String     leaveDt = null;
		@ApiModelProperty(notes = "상점번호")
		private Long       storeSeq = null;
	}
}
