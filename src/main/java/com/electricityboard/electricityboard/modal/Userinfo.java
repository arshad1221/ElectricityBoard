package com.electricityboard.electricityboard.modal;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Userinfo {
	
	
	  @Id
	  @Column(name = "id")
	  private int id;

	  @Column(name = "Applicant_Name")
	  private String Applicant_Name;

	  @Column(name = "Gender")
	  private String Gender;

	  @Column(name = "District")
	  private String District;
	  
	  
	  @Column(name = "State")
	  private String State;

	  @Column(name = "Pincode")
	  private Integer Pincode;

	  @Column(name = "Ownership")
	  private String Ownership;
	  
	  
	  @Column(name = "GovtID_Type")
	  private String GovtID_Type;

	  @Column(name = "ID_Number")
	  private long ID_Number;

	  @Column(name = "Category")
	  private String Category;
	  
	  
	  
	  
	  @Column(name = "Load_Applied")
	  private Integer Load_Applied;

	  @Column(name = "Date_of_Application")
	  private Date Date_of_Application;

	  @Column(name = "Date_of_Approval")
	  private String Date_of_Approval;
	  
	  
	  @Column(name = "Modified_Date")
	  private String Modified_Date;

	  @Column(name = "Reviewer_ID")
	  private Integer Reviewer_ID;

	  @Column(name = "STATUS")
	  private String STATUS;
	  
	  @Column(name = "Reviewer_Name")
	  private String Reviewer_Name;
	  
	  
	  @Column(name = "Reviewer_Comments")
	  private String Reviewer_Comments;
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  

}
