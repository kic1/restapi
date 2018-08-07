package com.nalanhi.common.base.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@MappedSuperclass
public class BaseEntity {

	@Column(updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdDate = null; // 등록일
	@Column(updatable=false)
	@CreatedBy
	private Long createdSeq  = null; // 등록자 회원번호
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedDate = null; // 수정일
	@LastModifiedBy
	private Long updatedSeq  = null; // 수정자 회원번호
}
