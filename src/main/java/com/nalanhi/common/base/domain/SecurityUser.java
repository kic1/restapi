package com.nalanhi.common.base.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.nalanhi.user.domain.User;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author jbeomh@gmail.com
 * @date 2018. 4. 19.
 * security user table entity
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Entity
@Table(name="tb_security_user")
public class SecurityUser extends BaseEntity {
	
	@Id
	private String	username		      = null; // 아이디
	private String	password		      = null; // 비밀번호
	
	private boolean accountNonExpired     = true; // 계정 만료 여부
	private boolean accountNonLocked      = true; // 계정 잠금 여부
	private boolean credentialsNonExpired = true; // 패스워드 만료 여부
	private boolean enabled               = true; // 계정 사용가능 여부
	private Long    userSeq		          = null; // 회원번호
	
	@Transient
	private List<SecurityAuthority> authoritys = new ArrayList<SecurityAuthority>();
	
	@OneToOne(fetch=FetchType.EAGER, optional=false)
	@JoinColumn(name="userSeq", referencedColumnName="seq", nullable=false, insertable=false, updatable=false)
	@NotFound(action = NotFoundAction.IGNORE)
	private User user;
	
	public SecurityUser(String username) {
		this.username = username;
	}
	
	public SecurityUser(String username, String password) {
		this.username = username;
		this.password = password;
	}
}
