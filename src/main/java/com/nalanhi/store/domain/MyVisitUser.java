package com.nalanhi.store.domain;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.nalanhi.common.base.domain.BaseEntity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 나의 회원
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
@Table(name="tb_my_visit_user")
public class MyVisitUser extends BaseEntity {
	
	@Id
	@GeneratedValue
	private Long    seq          = null; // seq
	
	private Long    storeSeq     = null; // 상점번호
	private Long    userSeq      = null; // 회원번호
	private String 	useYn        = null; // 사용 여부
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "storeSeq", referencedColumnName = "seq", nullable = false, insertable = false, updatable = false)
	private Store myVisitUser = null;
}
