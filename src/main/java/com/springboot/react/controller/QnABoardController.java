package com.springboot.react.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springboot.react.model.QnABoard;
import com.springboot.react.service.QnABoardService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class QnABoardController {

	@Autowired
	private QnABoardService qnABoardService;
	
	
	@RequestMapping(value = "/board/write", method = RequestMethod.POST)
	public ResponseEntity<String> insert(@RequestBody QnABoard board) {
		qnABoardService.insert(board);
		return ResponseEntity.ok("등록되었습니다.");
	}

	@RequestMapping(value = "/board/update")
	public void update(QnABoard board) {
		qnABoardService.update(board);
	}

	@RequestMapping("/board/delete")
	public String delete(QnABoard bno, RedirectAttributes rttr) {
		qnABoardService.delete(bno);
		rttr.addFlashAttribute("result", "delete success");
		return "redirect:board/list";
	}

	@RequestMapping(value = "/board/view")
	public QnABoard viewQnABoard() {
		QnABoard board = qnABoardService.select();
		return board;
	}
	
	@GetMapping("/board/list")
	    public List<QnABoard> getBoardList() {
		 return qnABoardService.boardList();
    }
	
}
