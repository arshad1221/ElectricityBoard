package com.electricityboard.electricityboard.controller;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.electricityboard.electricityboard.admin.Admins;
import com.electricityboard.electricityboard.adminrepo.AdminRepository;
import com.electricityboard.electricityboard.modal.Userinfo;
import com.electricityboard.electricityboard.repository.Repositoryuser;
import com.electricityboard.electricityboard.service.Userinfoservice;

import lombok.extern.log4j.Log4j2;

@RestController()
@CrossOrigin(origins = "*")
@Log4j2
@RequestMapping("/api/excel")
@EnableTransactionManagement
@Transactional("adminTransactionManager")
public class Controller {

	@Autowired
	Repositoryuser repositoryuser;


	@Autowired
	AdminRepository adminrepo;



	@Autowired
	public Userinfoservice Userinfoservice ;


	@GetMapping("/{ide}")
	public int userwithis(@PathVariable("ide")int id) {

		System.out.println(id);
		return id;

	}



	@GetMapping("/company/{id}")
	public ResponseEntity<Userinfo> getCompanyById(
			@PathVariable(value = "id") int id)
	{

		log.info("request recived for details with id: {} ",id);
		Userinfo u  =Userinfoservice.fetchinfo(id);




		return new ResponseEntity<>(u, HttpStatus.OK);
	}





	@GetMapping("/date")
	public ResponseEntity<List<Userinfo>> getbydate(
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date1, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date2)
	{
		// List<Userinfo> u=  repositoryuser.getAllBetweenDates(date1,date2);
		log.info("request recived for user application details between dates :{} and :{}",date1,date2);
		List<Userinfo> u=Userinfoservice.fetchapllicationbydate(date1,date2);

		System.out.println(u);

		return new ResponseEntity<>(u, HttpStatus.OK);
	}



	@GetMapping("/userlistu")
	public ResponseEntity<Map<String, BigInteger>> getapplican()

	{
		List<Object[]> result=    repositoryuser.getmonthwiseconnectionreq();




		Map<String,BigInteger> map = null;
		if(result != null && !result.isEmpty()){
			map = new HashMap<String,BigInteger>();
			for (Object[] object : result) {
				map.put(((String)object[0]),(BigInteger) object[1]);
			}



			System.out.println(map);
		}


		return new ResponseEntity<>(map, HttpStatus.OK);
	}















	@PutMapping("/updtaestatus")
	public ResponseEntity<Integer> updatestatus(@RequestParam("status") String status,@RequestParam("id") Integer id)


	{
		//List<Userinfo> u=  repositoryuser.findAll();
		Integer u=repositoryuser.updateuser(status,id);
		System.out.println(u);

		return new  ResponseEntity<>(u, HttpStatus.OK);

	}


	@GetMapping("/userlist")
	public ResponseEntity<List<Userinfo>> getapplicantById()

	{
		//List<Userinfo> u=  repositoryuser.findAll();
		List<Userinfo> u=Userinfoservice.fetchapllicationlist();
		System.out.println(u);

		return new  ResponseEntity<>(u, HttpStatus.OK);

	}


	@PostMapping("/admins")
	public ResponseEntity<Admins> updatedadmin()

	{
		new Admins();
		Admins a=Admins.builder()
				.admin_department("HR")
				.admin_name("REKHA")
				.admin_type("SYS")
				.admin_id(1)
				.build();
		System.out.println(a);
		adminrepo.save(a);

		return new  ResponseEntity<>(a, HttpStatus.OK);

	}



}
