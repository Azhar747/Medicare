package com.KitchenStory.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="Admin")
public class Admin {
	@Id
	@GeneratedValue
	@Column(name="Id")
	private Long Id;
	private String username;
	@Override
	public String toString() {
		return "Admin [Id=" + Id + ", username=" + username + ", password=" + password + ", email=" + email + "]";
	}
	private String password ;
	private String email;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


}
