package com.nalanhi.user.domain;

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
 * 나의 상점
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
@Table(name="tb_my_visit_store")
public class MyVisitStore extends BaseEntity {
	
	@Id
	@GeneratedValue
	private Long    seq          = null; // seq
	
	private Long    userSeq      = null; // 회원번호
	private Long    storeSeq     = null; // 상점번호
	private String 	useYn        = null; // 사용 여부
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userSeq", referencedColumnName = "seq", nullable = false, insertable = false, updatable = false)
	private User myVisitStore = null;
}
