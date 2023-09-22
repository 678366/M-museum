package com.springboot.react.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.react.model.QnABoard;
import com.springboot.react.model.QnABoardReply;

@Repository
public interface QnAReplyRepository extends JpaRepository<QnABoardReply, Integer>{

	QnABoardReply findTopByOrderByReplyRnoDesc();
	
	QnABoardReply save(QnABoardReply reply);
	
	void delete(QnABoardReply reply);
	
}
