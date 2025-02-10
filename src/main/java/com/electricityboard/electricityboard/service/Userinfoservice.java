package com.electricityboard.electricityboard.service;

import java.util.Date;
import java.util.List;

import com.electricityboard.electricityboard.modal.Userinfo;

public interface Userinfoservice {
	
	public Userinfo fetchinfo(int id) ;

	public List<Userinfo> fetchapllicationbydate(Date date1, Date date2);

	public List<Userinfo> fetchapllicationlist(); 

}
