package com.springboot.react.service;


import java.util.List;

import com.springboot.react.model.QnABoard;

public interface QnABoardService {

	void insert(QnABoard board);
	
	void update(QnABoard board);
	
	void delete(QnABoard board);
	
//	QnABoard select();
	
	List<QnABoard> boardList();

	QnABoard select(); 
	
}
