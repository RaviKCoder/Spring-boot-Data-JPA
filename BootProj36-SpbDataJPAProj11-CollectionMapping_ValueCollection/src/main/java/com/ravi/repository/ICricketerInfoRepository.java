package com.ravi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ravi.entity.CricketerInfo;

public interface ICricketerInfoRepository extends JpaRepository<CricketerInfo,Integer> {

}
