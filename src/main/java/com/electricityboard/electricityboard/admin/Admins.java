package com.electricityboard.electricityboard.admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Table(name="Adminsdb")
public class Admins {
	
	
	@Id
	@Column(name = "ADMIN_ID")
	private Integer admin_id;
	
	
	@Column(name = "ADMIN_NAME")
	private String admin_name;
	
	
	@Column(name = "ADMIN_TYPE")
	private String admin_type;
	
	
	@Column(name = "ADMIN_DEPARTMENT")
	private String admin_department;

}
