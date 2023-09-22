package com.springboot.react.service;

import java.util.List;

import com.springboot.react.model.QnABoardReply;

public interface QnABoardReplyService {

	void insert(QnABoardReply reply);
	
	void update(QnABoardReply reply);
	
	void delete(QnABoardReply reply);
	
	QnABoardReply select();
	
	List<QnABoardReply> findAll();
	
}
