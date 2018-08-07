package com.nalanhi.store.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.hibernate.envers.RelationTargetAuditMode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.nalanhi.common.base.domain.BaseEntity;
import com.nalanhi.push.domain.Push;
import com.nalanhi.push.domain.PushConfig;
import com.nalanhi.store.enumeration.BusiType;
import com.nalanhi.store.enumeration.StoreState;
import com.nalanhi.ticket.domain.Ticket;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 매장
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
@Table(name="tb_store")
public class Store extends BaseEntity {
	
	@Id
	@GeneratedValue
	private Long       seq        = null; // 상점번호
	
	private String     name       = null; // 상점 이름
	@Enumerated(EnumType.STRING)
	private StoreState storeState = null; // 상점 상태
	@Enumerated(EnumType.STRING)
	private BusiType   busiType   = null; // 업종 유형
	private String     regionCd   = null; // 지역 코드
	private String     joinDt     = null; // 가입일
	private String     tel        = null; // 전화번호
	private String     leaveDt    = null; // 탈퇴일
	
	@OneToMany(mappedBy = "myVisitUser", fetch = FetchType.LAZY)
	@NotAudited
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	private List<MyVisitUser> myVisitUsers = new ArrayList<MyVisitUser>();
	
	@OneToMany(mappedBy = "myWaitingUser", fetch = FetchType.LAZY)
	@NotAudited
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	private List<Ticket> myWaitingUsers = new ArrayList<Ticket>();
	
	@OneToMany(mappedBy = "sendStore", fetch = FetchType.LAZY)
	@NotAudited
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	private List<Push> myPushs = new ArrayList<Push>();
	
	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "seq", referencedColumnName = "storeSeq", nullable = false, insertable = false, updatable = false)
	@NotAudited
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	@NotFound(action = NotFoundAction.IGNORE)
	private PushConfig myPushConfig;
}
