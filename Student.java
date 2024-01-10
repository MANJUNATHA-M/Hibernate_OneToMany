package com.hibernate.onetomany.One_To_Many_Relation;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Student {
	@Id
	private int sId;
	private String sName;
	private int smarks;
	
	@OneToMany(mappedBy = "student")
	private List<Laptop> laps=new ArrayList<Laptop>();
	
	public List<Laptop> getLaps() {
		return laps;
	}
	public void setLaps(List<Laptop> laps) {
		this.laps = laps;
	}
	
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public int getSmarks() {
		return smarks;
	}
	public void setSmarks(int smarks) {
		this.smarks = smarks;
	}
	@Override
	public String toString() {
		return "Student [sId=" + sId + ", sName=" + sName + ", smarks=" + smarks + "]";
	}
}
