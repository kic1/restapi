package com.nalanhi.push.domain;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.nalanhi.common.base.domain.BaseEntity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 푸쉬 내용
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
@Table(name="tb_push_contents")
public class PushContents extends BaseEntity {
	
	@Id
	@GeneratedValue
	private Long   seq         = null; // 푸쉬 내용번호
	
	private String pushTitle   = null; // 제목
	private String pushMessage = null; // 내용
	private String pushTags    = null; // 태그
}
