package com.nalanhi.push.domain;

import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.nalanhi.common.base.domain.BaseEntity;
import com.nalanhi.push.enumeration.ReservationDayType;
import com.nalanhi.push.enumeration.ReservationTimeType;
import com.nalanhi.push.enumeration.TargetAgeType;
import com.nalanhi.push.enumeration.TargetGenderType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 푸쉬 전송 설정
 * @author jbeomh@gmail.com
 * @date 2018. 3. 14.
 *
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="tb_push_config")
public class PushConfig extends BaseEntity {
	
	@Id
	@GeneratedValue
	private Long                seq                 = null; // seq

	private Long                storeSeq            = null; // 상점번호
	@Enumerated(EnumType.STRING)
	private TargetGenderType    targetGenderType    = null; // 전송대상 성별 유형
	@Enumerated(EnumType.STRING)
	private TargetAgeType       targetAgeType       = null; // 전송대상 연령영역 유형
	@Enumerated(EnumType.STRING)
	private ReservationDayType  reservationDayType  = null; // 발송 예약요일 유형
	@Enumerated(EnumType.STRING)
	private ReservationTimeType reservationTimeType = null; // 발송 예약시간 유형
	private Long                pushContentsSeq     = null; // 푸쉬 내용번호
	private String              useYn               = null; // 사용 여부
	
	@OneToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name = "pushContentsSeq", referencedColumnName = "seq", nullable = false, insertable = false, updatable = false)
	@NotFound(action = NotFoundAction.IGNORE)
	private PushContents pushContents;
}
