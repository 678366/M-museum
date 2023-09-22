package com.springboot.react.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.react.model.QnABoard;
import com.springboot.react.repository.QnARepository;
import com.springboot.react.service.QnABoardService;

@Service("qnABoardService")
public class QnABoardServiceImple implements QnABoardService{

	@Autowired
	private QnARepository qnAdDao;
	
	@Override
	public void insert(QnABoard board) {
		
		board.setRegDate(LocalDate.now());
		board.setUpdateDate(LocalDate.now());
		
		qnAdDao.save(board);
	}

	// 글 수정
	@Override
	public void update(QnABoard board) {
		QnABoard currQna = qnAdDao.findTopByOrderByBnoDesc();
		
		currQna.setTitle(currQna.getTitle());
		currQna.setContent(currQna.getContent());
		currQna.setWriter(currQna.getWriter());
		currQna.setRegDate(LocalDate.now());
		currQna.setUpdateDate(LocalDate.now());
		
		// 글목록 수정한 것 인서트
		qnAdDao.save(currQna);
		
	}

	@Override
	public void delete(QnABoard board) {
		qnAdDao.delete(board);
	}

	// 글 조회
	@Override
	public QnABoard select() {
		return qnAdDao.findTopByOrderByBnoDesc();
	}

	@Override
	public List<QnABoard> boardList() {
		return qnAdDao.findAll();
	}


}
