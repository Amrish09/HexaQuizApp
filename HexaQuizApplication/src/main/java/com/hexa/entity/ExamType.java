package com.hexa.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="examtype")
public class ExamType {
	
	@Id  //setting the primary key 
	@Column(name="examid")
	private int examId;
	
	@Column(name="examtype")
	private String examType;
	
	
	//created a one-to-many relationship with the QuizTypeApplication.java
	@OneToMany(mappedBy="eType",fetch=FetchType.LAZY)
	//created As a set because when it is one to many condtion we wil 
	//get a set of values(a collection of values)
	private Set<QuizQuestion> qlist;
	
	
				
								public Set<QuizQuestion> getQlist() {
									return qlist;
								}
								public void setQlist(Set<QuizQuestion> qlist) {
									this.qlist = qlist;
								}
	public int getExamId() {
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	public String getExamType() {
		return examType;
	}
	public void setExamType(String examType) {
		this.examType = examType;
	}
	

}
