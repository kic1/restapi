package com.nalanhi.helpdesk.domain;

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
 * 고객센터 문의사항 첨부파일
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
@Table(name="tb_helpdesk_qna_file")
public class HelpdeskQnaFile extends BaseEntity {
	
	@Id
	@GeneratedValue
	private Long   seq            = null; // seq

	private Long   helpdeskQnaSeq = null; // helpdeskQnaSeq
	private String realFileNm     = null; // 실제 파일명
	private String saveFileNm     = null; // 저장 파일명
	private String fileSavePath   = null; // 파일 저장 경로
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "helpdeskQnaSeq", referencedColumnName="seq", nullable = false, insertable = false, updatable = false)
	private HelpdeskQna helpdeskQna = new HelpdeskQna();
}
