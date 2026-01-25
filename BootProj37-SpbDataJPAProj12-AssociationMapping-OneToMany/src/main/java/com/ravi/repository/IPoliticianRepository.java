package com.ravi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ravi.entity.Politician;

public interface IPoliticianRepository extends JpaRepository<Politician, Integer> {

}
