package com.nalanhi.common.definition.message;

/**
 * @author jbeomh@gmail.com
 * @date 2017. 8. 29.
 *
 */
public enum Messages {
 
	/**
	 * E0001xxxx : 공통
	 ********************************************************************************************/
	 E00010001  // 유효성 검사에 실패하였습니다.
	,E00010002  // 해당 정보가 없습니다.
	
	/**
	 * E0003xxxx : 회원
	 ********************************************************************************************/
	,E00030001  // 비밀번호를 확인한 후 다시 입력해주세요
	,E00030002  // 새 비밀번호를 확인한 후 다시 입력해주세요
	,E00030003  // 입력하신 회원정보는 존재하지 않습니다

	/**
	 * E0004xxxx : 근무시간
	 ********************************************************************************************/
	,E00040001  // 이번 TR 차수에 해당하는 날짜가 없습니다.
}
