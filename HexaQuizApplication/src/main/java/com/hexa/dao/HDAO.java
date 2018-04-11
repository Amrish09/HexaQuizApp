package com.hexa.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;



import com.hexa.entity.ExamType;
import com.hexa.entity.UserHistory;
import com.hexa.entity.UserTable;

public interface HDAO {
	
	public List<UserHistory> viewHistory(int uid);
	
	public int saveHistory(UserHistory obj);
	
	public UserTable getLogin(String userName,String password) throws NotFoundException;
	
	
	

}
