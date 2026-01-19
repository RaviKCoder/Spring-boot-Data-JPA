package com.ravi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ravi.entity.Faculty;

public interface IFacultyRepository extends JpaRepository<Faculty,Integer> {

}
