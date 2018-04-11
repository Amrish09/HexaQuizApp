package com.hexa.service;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import com.hexa.entity.ExamType;
import com.hexa.entity.QuizQuestion;
import com.hexa.entity.UserTable;

public interface Qser {
	
	
	//
	public Set<QuizQuestion> generateQues(int examId);
	
	public int evaluate(Map<Integer,String> amap,int examId,UserTable user);
	
	
	
	

}
