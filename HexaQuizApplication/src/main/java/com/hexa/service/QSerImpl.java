package com.hexa.service;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hexa.dao.HDAO;
import com.hexa.dao.HistoryImpl;
import com.hexa.dao.QDAO;
import com.hexa.dao.QuizImpl;
import com.hexa.entity.ExamType;
import com.hexa.entity.QuizQuestion;
import com.hexa.entity.UserHistory;
import com.hexa.entity.UserTable;


@Service("quizser")
public class QSerImpl implements Qser{
	
	@Autowired
	QDAO dao;
	
	@Autowired
	HDAO hdao;

	private static Map<Integer,Map> exammap = new HashMap<>();
	
	
	//Generating the required Questions Randomly
	
	@Override
	@Transactional(readOnly=false)
	public Set<QuizQuestion> generateQues(int examId) {
		System.out.println("generate ques");
		Map<Integer,QuizQuestion> map = null;
		if(!exammap.containsKey(examId)) {
			 map = dao.getQuestions(examId);
			exammap.put(examId, map);
		}else {
			map = exammap.get(examId);
		}

		Set<QuizQuestion> set = new HashSet<>();
		int high=1030;
		int low =1000;
		Random r =new Random();
		int qno=0;
		while(set.size()<5) {
			qno = r.nextInt(high-low)+low;
			if(map.containsKey(qno)) {
				set.add(map.get(qno));
				
			}
			
		}
		System.out.println("size"+ set.size());
		return set;
		
	}
	
	//Evaluating the Users Score!!
	
	@Override
	@Transactional(readOnly=false)
	public int evaluate(Map<Integer, String> amap, int examId, UserTable user) {
		
		
		int score=0;
		Map<Integer,QuizQuestion> qmap = dao.getQuestions(examId);
		Set<Integer> set = amap.keySet();
		for(int key: set) {
			String val1 = amap.get(key); //ans
			System.out.println(val1);
		QuizQuestion ques = qmap.get(key);	//all
		     if(val1.equals(ques.getAns()))  {
		    	 score++;
		     }
		     UserHistory uhistory = new UserHistory();
								
				ExamType exam = new ExamType();
				exam.setExamId(examId);
				uhistory.setDate(new Date());
				uhistory.setMarks(score);
				
				
				uhistory.setHtype(exam);
				uhistory.setUid(user);
				hdao.saveHistory(uhistory);
				
				
		}
		
		return score;
	}
	
}
