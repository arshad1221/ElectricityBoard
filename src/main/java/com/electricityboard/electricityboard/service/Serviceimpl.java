package com.electricityboard.electricityboard.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electricityboard.electricityboard.exceptionhandler.CustomException;
import com.electricityboard.electricityboard.modal.Userinfo;
import com.electricityboard.electricityboard.repository.Repositoryuser;

import lombok.extern.log4j.Log4j2;
import net.bytebuddy.implementation.bytecode.Throw;


@Service 
@Log4j2
public class Serviceimpl implements Userinfoservice {

	@Autowired
	Repositoryuser repositoryuser;



	@Override
	public Userinfo fetchinfo(int id) {
		// TODO Auto-generated method stub

		log.info("Fetching user details with id :{}",id);


		Userinfo u=repositoryuser.findById(id);
		return u;	
	}








	@Override
	public List<Userinfo> fetchapllicationbydate(Date date1, Date date2) {

		log.info("Fetching user application details between dates :{} and :{}",date1,date2);
		List<Userinfo> u=repositoryuser.getAllBetweenDates(date1, date2);

		return u;
	}



	@Override
	public List<Userinfo> fetchapllicationlist() {

		log.info("Fetching user application list");
		List<Userinfo> u=repositoryuser.findAll();
		return u;
	}

}
