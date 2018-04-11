package com.hexa.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.hexa.entity.ExamType;
import com.hexa.entity.QuizQuestion;
import com.hexa.entity.UserHistory;
import com.hexa.entity.UserTable;

/**
 * 
 * @author Amrish
 * @version 1.0.0
 * <p>It is a class used to get Data from the Database</p>
 */

@Repository("quizdao")
public class HistoryImpl implements HDAO{
	
	@Autowired
    private  SessionFactory sfac;
	
 Logger logger = LoggerFactory.getLogger("empapp");


public void setSfac(SessionFactory sfac) {
	this.sfac = sfac;
}
/**
 * @param uid Integer value.
 * @return lst  List of UserHistory.
 * <p>This is used for getting the history of the users</p>
 */

////VIEW HISTORY
	@Override
	public List<UserHistory> viewHistory(int uid) {
		Session sess = sfac.openSession();
		String hql = "from UserHistory u inner join fetch u.htype inner join fetch u.uid us where us.userId=?";
		Query qry = sess.createQuery(hql);
		qry.setParameter(0, uid);
		
		List<UserHistory> lst =qry.list();
		sess.close();
		return lst;
	}
	/**
	 * @param  obj userhistory object
	 * @return Integer 007.
	 * <p>This is used forsaveHistory of the users</p>
	 */
	
	////////SAVE HISTORY
	@Override
	public int saveHistory(UserHistory obj) {
	
		Session sess = sfac.openSession();
		Transaction tx = sess.beginTransaction();
		
		sess.save(obj);
		tx.commit();
		sess.close();
	
		return 007;
	}
	
	/**
	 * @param  userName username 
	 * @param  password password
	 * @return utable of userTable instance.
	 * <p>This is used forsaveHistory of the users</p>
	 */
	//////SAVE LOGIN 
	@Override
	public  UserTable getLogin(String userName, String password) throws NotFoundException {
		Session sess = sfac.openSession();
		String hql = "from UserTable ut where userName=? and password=? ";
		Query qry = sess.createQuery(hql);
		qry.setParameter(0, userName);
		qry.setParameter(1,password );
		
		UserTable utable = (UserTable)qry.uniqueResult();
		sess.close();
		if(utable == null) {
			throw new NotFoundException("Please Enter the  CORRECT UserName and Password To play the quiz");
			
		} 
			
			return utable;
			

	}
}
