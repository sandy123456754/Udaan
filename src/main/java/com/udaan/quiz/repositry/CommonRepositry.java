package com.udaan.quiz.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.udaan.quiz.entity.CommonEntity;

@Repository
public interface CommonRepositry extends CrudRepository<CommonEntity, String>{

	@Query("select * from CommonEntity c where c.quiz_id = ?1 limit 10")
	public List<CommonEntity> findByQuizId(Long quizId);
	
}
