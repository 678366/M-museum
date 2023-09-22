package com.springboot.react.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SequenceGenerator(
		name = "seq_replyA_gen", // 시퀀스 생성기 이름
		sequenceName = "seq_reply_A", // 시퀀스 이름(IDX_SEQ)
		initialValue = 1, // 시퀀스 초기값 
		allocationSize = 1 // 시퀀스 증가량
		)

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_reply_a")
public class QnABoardReply {
	
	@Id
//	@GeneratedValue : 	제약조건을 걸지 않으면, PK 값을 각 DBMS에 맞는 자동증가 컬럼으로 만들어준다.
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
			generator = "seq_replyA_gen")
	
	@Column(name = "rno")
	private Integer replyRno;

	@ManyToOne
	@JoinColumn(name = "bno")
	private QnABoard bno;
	
	@Column(name = "reply")
	private String reply;
	
	@Column(name = "replyer")
	private String replyer;
	
	@Column(name = "replydate")
	private Date replyDate;
	
	@Column(name = "updatedate")
	private Date replyUpdateDate;

}
