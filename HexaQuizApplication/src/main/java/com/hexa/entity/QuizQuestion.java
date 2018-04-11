package com.hexa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="quizquestion")
public class QuizQuestion {
	
	@Id
	@Column(name="quesid")
	private int quesId;
	
	//created a many-to-one relationship with the ExamType.java
	@ManyToOne
	@JoinColumn(name="examid", referencedColumnName="examId")
	private ExamType eType;
	
	
	public ExamType geteType() {
		return eType;
	}
	public void seteType(ExamType eType) {
		this.eType = eType;
	}
	
	@Column(name="quesdesc")
	private String quesDesc;
	@Column(name="optA")
	private String optA;
	@Column(name="optB")
	private String optB;
	@Column(name="optC")
	private String optC;
	@Column(name="Ans")
	private String ans;
	
	
	
	public int getQuesId() {
		return quesId;
	}
	public void setQuesId(int quesId) {
		this.quesId = quesId;
	}
	public String getQuesDesc() {
		return quesDesc;
	}
	public void setQuesDesc(String quesDesc) {
		this.quesDesc = quesDesc;
	}
	public String getOptA() {
		return optA;
	}
	public void setOptA(String optA) {
		this.optA = optA;
	}
	public String getOptB() {
		return optB;
	}
	public void setOptB(String optB) {
		this.optB = optB;
	}
	public String getOptC() {
		return optC;
	}
	public void setOptC(String optC) {
		this.optC = optC;
	}
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		ans = ans;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return quesId + " " + quesDesc + " " + optA + " " + optB + " " + optC + " " + ans;
	}
	

}
