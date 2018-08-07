package com.nalanhi.push.domain;

import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.hibernate.envers.RelationTargetAuditMode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.nalanhi.common.base.domain.BaseEntity;
import com.nalanhi.push.enumeration.PushState;
import com.nalanhi.store.domain.Store;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 푸쉬 발송현황
 * @author jbeomh@gmail.com
 * @date 2018. 3. 14.
 *
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Audited
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="tb_push")
public class Push extends BaseEntity {
	
	@Id
	@GeneratedValue
	private Long      seq             = null; // 푸쉬번호
	
	private Long      storeSeq        = null; // 상점번호
	private Long      pushContentsSeq = null; // 푸쉬 내용번호
	@Enumerated(EnumType.STRING)
	private PushState pushState       = null; // 푸쉬 상태
	private String    targetTel       = null; // 전송대상 전화번호
	
	@OneToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name = "pushContentsSeq", referencedColumnName = "seq", nullable = false, insertable = false, updatable = false)
	@NotFound(action = NotFoundAction.IGNORE)
	@NotAudited
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	private PushContents pushContents;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "storeSeq", referencedColumnName = "seq", nullable = false, insertable = false, updatable = false)
	@NotFound(action = NotFoundAction.IGNORE)
	@NotAudited
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	private Store sendStore;
}
