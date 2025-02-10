package com.electricityboard.electricityboard.modal;

import java.math.BigInteger;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Connectionresponse {

	BigInteger  totalconnectionrequest;
	String month;
	
}
