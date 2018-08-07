package com.nalanhi.common.base.domain;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.nalanhi.common.base.domain.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 에러
 * @author jbeomh@gmail.com
 * @date 2018. 3. 13.
 *
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@Table(name="tb_error")
public class Error extends BaseEntity {
	
	@Id
	@GeneratedValue
	private Long    seq              = null; // seq
	
	private String  requestProtocol  = null; // requestProtocol
	private String  requestMethod    = null; // requestMethod
	private String  requestURI       = null; // requestURI
	private String  requestParameter = null; // requestParameter
	private String  requestHeader    = null; // requestHeader
	private String  errorClassNm     = null; // errorClassNm
	private String  errorName        = null; // errorName
	private String  errorMessage     = null; // errorMessage
}
