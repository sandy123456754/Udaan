package com.udaan.quiz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.udaan.quiz.entity.CommonEntity;
import com.udaan.quiz.entity.QuestionEntity;
import com.udaan.quiz.entity.QuizEntity;
import com.udaan.quiz.model.Answers;
import com.udaan.quiz.model.Question;
import com.udaan.quiz.model.Quiz;
import com.udaan.quiz.repositry.CommonRepositry;
import com.udaan.quiz.repositry.QuestionRepositry;
import com.udaan.quiz.repositry.QuizRepositry;

@Service
public class QuizService {

	@Autowired
	private QuizRepositry quizRepositry;
	
	@Autowired
	private CommonRepositry commonRepositry;
	
	@Autowired
	private QuestionRepositry questionRepositry;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	public Quiz createQuiz(Quiz quiz) {
		List<String> questions = quiz.getListOfQuestions();
		QuizEntity quizEntity = quizRepositry.save(new QuizEntity(quiz.getName()));
		for(String s : questions) {
			commonRepositry.save(new CommonEntity(""+quizEntity.getId()+s, quizEntity.getId(), Long.parseLong(s)));
		}
		quiz.setId(quizEntity.getId());
		return quiz;
	}
	
	public List<Quiz> getQuizes(int pages) throws Exception{

		List<Quiz> quizs = new ArrayList<Quiz>();

		List<QuizEntity> quizEntities = quizRepositry.findAll(PageRequest.of(0, pages));
		for (QuizEntity q : quizEntities) {
			List<CommonEntity> commonEntities = commonRepositry.findByQuizId(q.getId());

			Optional<QuizEntity> quiz = quizRepositry.findById(q.getId());

			if (quiz.isPresent()) {
				List<Question> questions = new ArrayList<Question>();
				for (CommonEntity commonEntity : commonEntities) {
					Optional<QuestionEntity> entity = questionRepositry.findById(commonEntity.getQuestionId());
					if (entity.isPresent()) {
						QuestionEntity questionEntity = entity.get();
						Question question = new Question();
						question.setName(questionEntity.getName());
						question.setListOfAnswers(objectMapper.readValue(questionEntity.getListOfAnswers(), Answers.class).getAnswers());
						question.setCorrectAnswer(questionEntity.getCorrectAnswer());
						questions.add(question);
					}
				}
				Quiz quizModel = new Quiz();
				quizModel.setQuestions(questions);
				quizModel.setName(quiz.get().getName());
				quizs.add(quizModel);

			}
		}
		return quizs;

	}
	
}
