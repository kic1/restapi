package com.nalanhi.ticket.domain;

import javax.persistence.*;

import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.hibernate.envers.RelationTargetAuditMode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.nalanhi.common.base.domain.BaseEntity;
import com.nalanhi.store.domain.Store;
import com.nalanhi.ticket.enumeration.TicketState;
import com.nalanhi.user.domain.User;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 대기표
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
@Table(name="tb_ticket")
public class Ticket extends BaseEntity {
	
	@Id
	@GeneratedValue
	private Long        seq            = null; // seq
	
	private Long        storeSeq       = null; // 상점번호
	private Long        userSeq        = null; // 회원번호
	private Long        ticketNo       = null; // 티켓 표시 번호
	@Enumerated(EnumType.STRING)
	private TicketState ticketState    = null; // 티켓 상태
	private Integer     waitingNumbers = null; // 예약 인원 수
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "storeSeq", referencedColumnName = "seq", nullable = false, insertable = false, updatable = false)
	@NotAudited
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	private Store myWaitingUser = null;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userSeq", referencedColumnName = "seq", nullable = false, insertable = false, updatable = false)
	@NotAudited
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	private User myWaitingStore = null;
}
