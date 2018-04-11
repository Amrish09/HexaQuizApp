package com.hexa.dao;

import java.util.Map;

import com.hexa.entity.ExamType;
import com.hexa.entity.QuizQuestion;

public interface QDAO {
	public Map<Integer, QuizQuestion> getQuestions(int examId);

}
