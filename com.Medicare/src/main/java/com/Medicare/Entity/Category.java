package com.Medicare.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Category {
	@Id
	@GeneratedValue
	private int ID;
	
	private String name;
	
     public Category() {
		
		
	}
	public Category(String name) {
		
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Category [ID=" + ID + ", name=" + name + "]";
	}
	public int  getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
}
