package com.springboot.react.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.react.model.QnABoardReply;
import com.springboot.react.repository.QnAReplyRepository;
import com.springboot.react.service.QnABoardReplyService;

@Service
public class QnABoardReplyServiceImpl implements QnABoardReplyService{

	@Autowired
	private QnAReplyRepository replyDao;
	
	@Override
	public void insert(QnABoardReply reply) {
		replyDao.save(reply);
	}

	// 글 수정
	@Override
	public void update(QnABoardReply reply) {
		// 최근 글 가져오기
		QnABoardReply currReply = replyDao.findTopByOrderByReplyRnoDesc();
		
		currReply.setReply(reply.getReply());
		currReply.setReplyer(reply.getReplyer());
		currReply.setReplyDate(reply.getReplyDate());
		
		// 글 목록 수정한 것 인서트
		replyDao.save(currReply);
	}

	@Override
	public void delete(QnABoardReply reply) {
		replyDao.delete(reply);
	}

	@Override
	public QnABoardReply select() {
		return replyDao.findTopByOrderByReplyRnoDesc();
	}

	@Override
	public List<QnABoardReply> findAll() {
		return replyDao.findAll();
	}

}
