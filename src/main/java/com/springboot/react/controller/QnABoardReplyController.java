package com.springboot.react.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.react.model.QnABoardReply;
import com.springboot.react.service.QnABoardReplyService;

@CrossOrigin
@RestController
public class QnABoardReplyController {

	@Autowired
	private QnABoardReplyService qnABoardReplyService;
	
	@RequestMapping(value = "insertReply.do")
	public void insert(QnABoardReply reply) {
		qnABoardReplyService.insert(reply);
	}
	
	@RequestMapping(value = "updateReply.do")
	public void update(QnABoardReply reply) {
		qnABoardReplyService.update(reply);
	}
	
	@RequestMapping(value = "deleteReply.do")
	public void delete(QnABoardReply reply) {
		qnABoardReplyService.delete(reply);
	}
	
	@RequestMapping(value = "viewReply.do")
	public QnABoardReply viewReply() {
		QnABoardReply reply = qnABoardReplyService.select();
		return reply;
	}
	
	@RequestMapping(value = "replyList.do")
	public List<QnABoardReply> findAll() {
		return qnABoardReplyService.findAll();
	}
	
}
