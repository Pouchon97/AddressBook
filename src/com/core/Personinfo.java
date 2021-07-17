package com.core;

import javax.swing.JOptionPane;

public class Personinfo {
	private String name;
	private String address;
	private String phone;
	private String gmail;
	
	public Personinfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Personinfo(String name, String address, String phone, String gmail) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.gmail = gmail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	
	
	
}