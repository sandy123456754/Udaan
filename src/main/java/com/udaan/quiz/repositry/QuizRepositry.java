package com.udaan.quiz.repositry;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.udaan.quiz.entity.QuizEntity;

@Repository
public interface QuizRepositry extends CrudRepository<QuizEntity, Long>{

//	@Query( value =  "select * from quiz q limit 10", nativeQuery = true)
	public List<QuizEntity> findAll(Pageable pages);
	
}
