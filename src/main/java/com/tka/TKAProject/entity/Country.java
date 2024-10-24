package com.tka.TKAProject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity		
public class Country {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	private String cname;
	
	public Country(){
		
	}

	public Country(String cname) {
		super();
		this.cname = cname;
	}

	public int getcid() {
		return cid;
	}

	public void setcid(int cid) {
		this.cid = cid;
	}

	public String getcname() {
		return cname;
	}

	public void setcname(String cname) {
		this.cname = cname;
	}

	@Override
	public String toString() {
		return "Country [cid=" + cid + ", cname=" + cname + "]";
	}
	
	
}
