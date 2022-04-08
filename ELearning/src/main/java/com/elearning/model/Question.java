package com.elearning.model;

import java.util.List;

public class Question {

	private Long id;
	private String question;
	private String correctAnswer;
	private List<Answer> answersList;

	public Question() {
		super();
	}

	public Question(Long id, String question) {
		super();
		this.id = id;
		this.question = question;
	}

	public Question(Long id, String question, String correctAnswer, List<Answer> answersList) {
		super();
		this.id = id;
		this.question = question;
		this.correctAnswer = correctAnswer;
		this.answersList = answersList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public List<Answer> getAnswersList() {
		return answersList;
	}

	public void setAnswersList(List<Answer> answersList) {
		this.answersList = answersList;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", correctAnswer=" + correctAnswer + ", answersList="
				+ answersList + "]";
	}

}
