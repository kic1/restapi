package com.nalanhi.common.base.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jbeomh@gmail.com
 * @date 2018. 4. 19.
 * security authority table entity
 */
@Data
@Entity
@NoArgsConstructor
@Table(name="tb_security_authority")
public class SecurityAuthority {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer seq      = null;
	private String  username = null;
	private String  roleId   = null;
	
	/**
	 * user 권한 등록
	 * @param userSeq
	 * @param roleId
	 */
	public SecurityAuthority(String username, String roleId) {
		this.username = username;
		this.roleId   = roleId;
	}
	
	/**
	 * user 권한 삭제
	 * @param seq
	 */
	public SecurityAuthority(Integer seq) {
		this.seq = seq;
	}
}
