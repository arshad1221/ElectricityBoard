package com.electricityboard.electricityboard.repository;

import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.electricityboard.electricityboard.modal.Userinfo;

@Repository
@Primary
@Transactional
public interface Repositoryuser extends JpaRepository<Userinfo, Integer> {
	
	
	Userinfo findById(int id);
	
	@Query(value = "from Userinfo  where date_of_application BETWEEN :startDate AND :endDate")
	public List<Userinfo> getAllBetweenDates(@Param("startDate")Date startDate,@Param("endDate")Date endDate);
	
//	select 
//    from userinfo
//    group by date_format(Date_of_Application, '%M');
	
	@Query(value ="select date_format(Date_of_Application, '%M') as month,count(id) as count from userinfo group by date_format(Date_of_Application, '%M')" , nativeQuery = true)
	public List<Object[]> getmonthwiseconnectionreq();


	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("UPDATE Userinfo u SET u.STATUS = :status  where u.id = :id")
	Integer updateuser(@Param("status") String status,@Param("id") Integer id);

//	@Modifying
//    @Query("UPDATE Company c SET c.address = :address WHERE c.id = :companyId")
//    int updateAddress(@Param("companyId") int companyId, @Param("address") String address);
	
	
}
