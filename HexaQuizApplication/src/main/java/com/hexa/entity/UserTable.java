package com.hexa.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Userdetails")
public class UserTable {
	
	@Id
	@Column(name="userid")
	private int userId;
	
	@Column(name="username")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="emailid")
	private String emaiId;
	
	
	
	@OneToMany(mappedBy="uid",fetch=FetchType.LAZY)
	private Set<UserHistory> hlist;
	
						public Set<UserHistory> getHlist() {
							return hlist;
						}
					
						public void setHlist(Set<UserHistory> hlist) {
							this.hlist = hlist;
						}
						
						
						
						
						
						

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmaiId() {
		return emaiId;
	}

	public void setEmaiId(String emaiId) {
		this.emaiId = emaiId;
	}

	@Override
	public String toString() {
		return "UserTable [userId=" + userId + ", userName=" + userName + ", password=" + password + ", emaiId="
				+ emaiId + "]";
	}

}
