package com.springboot.react.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.react.model.QnABoard;

//public interface QnARepository extends CrudRepository<QnABoard, Integer>{
@Repository
public interface QnARepository extends JpaRepository<QnABoard, Integer>{

	QnABoard findTopByOrderByBnoDesc();
	
	QnABoard save(QnABoard board);
	
	void delete(QnABoard board);
	
}
