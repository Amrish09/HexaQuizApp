package com.hexa.dao;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hexa.entity.ExamType;
import com.hexa.entity.QuizQuestion;

/**
 * 
 * @author Amrish
 * @version 1.0.0
 * <p>It is a class used to get Questions from the Database</p>
 */
 
@Repository("historydao")
public class QuizImpl implements QDAO{
	
	private Logger logger = LoggerFactory.getLogger("empapp");

	@Autowired
    private SessionFactory sfac;

	/**
	 * @param uid Integer value.
	 * @return lst  List of UserHistory.
	 * <p>This is used for getting the history of the users</p>
	 */
	@Override
	public Map<Integer, QuizQuestion> getQuestions(int examId) {
		Session sess = sfac.openSession();
		String hql = "from QuizQuestion q inner join   fetch q.eType where q.eType.examId=?";
		Query qry = sess.createQuery(hql);
		qry.setParameter(0, examId);
		List<QuizQuestion> lst =qry.list();
		
		Map<Integer,QuizQuestion> map = new HashMap<>();
		for(QuizQuestion q : lst) {
			map.put(q.getQuesId(),q);
			
		}
		sess.close();
		return map;
	}
	 

	
		
	
	}
	
	


