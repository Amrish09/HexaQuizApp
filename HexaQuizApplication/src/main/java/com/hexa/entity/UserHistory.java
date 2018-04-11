package com.hexa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="userhistory")
public class UserHistory {
	
	@Id
	@Column(name="historyid")
	private int historyid;
	@Column(name="marks")
	private float marks;
	@Column(name="date")
	private Date date;
	
							//foreign key for exam type table
							@ManyToOne 
							@JoinColumn(name="hexamid", referencedColumnName="examid")
							private ExamType htype;
							
						
							public ExamType getHtype() {
								return htype;
							}
							public void setHtype(ExamType htype) {
								this.htype = htype;
							}
							
							
							//foreign key for User Table table
							@ManyToOne
							@JoinColumn(name="uid", referencedColumnName="userid")
							private UserTable uid ; 
							
							public UserTable getUid() {
								return uid;
							}
							public void setUid(UserTable uid) {
								this.uid = uid;
							}
	
	
	
	
	
	public int getHistoryId() {
		return historyid;
	}
	public void setHistoryId(int historyId) {
		this.historyid = historyId;
	}
	public float getMarks() {
		return marks;
	}
	public void setMarks(float marks) {
		this.marks = marks;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "UserHistory [historyId=" + historyid + ", marks=" + marks + ", date=" + date + "]";
	}
	

}
