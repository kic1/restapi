package com.nalanhi.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.hibernate.envers.RelationTargetAuditMode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.nalanhi.common.base.domain.BaseEntity;
import com.nalanhi.helpdesk.enumeration.QuestionState;
import com.nalanhi.helpdesk.enumeration.QuestionType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 고객센터 문의사항
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
@Table(name="tb_helpdesk_qna")
public class HelpdeskQna extends BaseEntity {
	
	@Id
	@GeneratedValue
	private Long          seq             = null; // seq

	@Enumerated(EnumType.STRING)
	private QuestionType  questionType    = null; // 질문 유형
	@Enumerated(EnumType.STRING)
	private QuestionState questionState   = null; // 질문 상태
	private String        questionTitle   = null; // 질문 제목
	private String        questionMessage = null; // 질문 내용
	private String        answerTitle     = null; // 답변 제목
	private String        answerMessage   = null; // 답변 내용
	
	@OneToMany(mappedBy = "helpdeskQna")
	@NotAudited
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	private List<HelpdeskQnaFile> helpdeskQnaFileList = new ArrayList<HelpdeskQnaFile>();
}
