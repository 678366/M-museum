package com.springboot.react.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SequenceGenerator(
		name = "seq_boardA_gen", // 시퀀스 생성기 이름
		sequenceName = "seq_board_A", // 시퀀스 이름(IDX_SEQ)
		initialValue = 1, // 시퀀스 초기값
		allocationSize = 1 // 시퀀스 증가량
		)
@Data @NoArgsConstructor
@AllArgsConstructor @Builder @Entity
@Table(name = "tbl_board_a")
public class QnABoard {
	
	@Id	@GeneratedValue(strategy = GenerationType.SEQUENCE,
	generator = "seq_boardA_gen" ) // auto_increment
	
	@Column(name = "bno")
	private Integer bno;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "writer")
	private String writer;
	
	@Column(name = "regdate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate regDate;
	
	@Column(name = "updatedate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate updateDate;
	
}
