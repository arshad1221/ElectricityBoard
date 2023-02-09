package com.electricityboard.electricityboard.adminrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.electricityboard.electricityboard.admin.Admins;


@Repository
@Transactional
public interface AdminRepository extends  JpaRepository<Admins, Integer> {




}
