package com.nalanhi.user.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.hibernate.envers.RelationTargetAuditMode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.nalanhi.common.base.domain.BaseEntity;
import com.nalanhi.common.util.date.UDate;
import com.nalanhi.ticket.domain.Ticket;
import com.nalanhi.user.enumeration.GenderType;
import com.nalanhi.user.enumeration.JoinType;
import com.nalanhi.user.enumeration.UserState;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 회원
 * @author jbeomh@gmail.com
 * @date 2018. 3. 12.
 *
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Audited
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="tb_user")
public class User extends BaseEntity {
	
	@Id
	@GeneratedValue
	private Long       seq        = null; // 회원번호
	
	private String     name       = null; // 성명
	@Enumerated(EnumType.STRING)
	private UserState  userState  = null; // 회원 상태
	@Enumerated(EnumType.STRING)
	private JoinType   joinType   = null; // 회원가입 유형
	private String     email      = null; // 이메일
	private String     joinDt     = null; // 가입일
	private String     birthDt    = null; // 생일
	@Enumerated(EnumType.STRING)
	private GenderType genderType = null; // 성별 유형
	private String     tel        = null; // 전화번호
	private String     snsToken   = null; // SNS 회원 가입 토큰
	private String     leaveDt    = null; // 탈퇴일
	private Long       storeSeq   = null; // 상점번호
	
	@Transient
	private Integer rev = null; // revision number
	
	@OneToMany(mappedBy = "myVisitStore", fetch = FetchType.LAZY)
	@NotAudited
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	private List<MyVisitStore> myVisitStores = new ArrayList<MyVisitStore>();
	
	@OneToMany(mappedBy = "myFavorStore", fetch = FetchType.LAZY)
	@NotAudited
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	private List<MyFavorStore> myFavorStores = new ArrayList<MyFavorStore>();
	
	@OneToMany(mappedBy = "myWaitingStore", fetch = FetchType.LAZY)
	@NotAudited
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	private List<Ticket> myWaitingStores = new ArrayList<Ticket>();
	
	/** 리비전 번호 저장 */
	public void saveRevisionNumber(Integer rev) {
		this.rev = rev;
	}
	
	/** 회원 가입 */
	public User(String name, JoinType joinType, String email, String birthDt, GenderType genderType, String tel, String snsToken) {
		this.name       = name;
		this.userState  = UserState.JOINED;
		this.joinType   = joinType;
		this.email      = email;
		this.joinDt     = UDate.getToday();
		this.birthDt    = birthDt;
		this.genderType = genderType;
		this.tel        = tel;
		this.snsToken   = snsToken;
	}
	
	/** 회원 수정 */
	public void updateUser(String name, String email, String birthDt, GenderType genderType, String tel) {
		this.name       = name;
		this.email      = email;
		this.birthDt    = birthDt;
		this.genderType = genderType;
		this.tel        = tel;
	}
	
	/** 회원 복구 */
	public void restoreUser(String name, UserState userState, JoinType joinType, String email, String joinDt, String birthDt, GenderType genderType, String tel, String snsToken, String leaveDt, Long storeSeq) {
		this.name       = name;
		this.userState  = userState;
		this.joinType   = joinType;
		this.email      = email;
		this.joinDt     = joinDt;
		this.birthDt    = birthDt;
		this.genderType = genderType;
		this.tel        = tel;
		this.snsToken   = snsToken;
		this.leaveDt    = leaveDt;
		this.storeSeq   = storeSeq;
	}
	
	/** 회원 삭제 */
	public void deleteUser(Long seq) {
		this.seq       = seq;
		this.userState = UserState.LEAVED;
		this.leaveDt   = UDate.getToday();
	}
	
	/** 생일 수정 */
	public void saveBirthDt(Long seq, String birthDt) {
		this.seq       = seq;
		this.birthDt = birthDt;
	}
}
