package com.ravi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ravi.entity.Project;

public interface IProjectRepository extends JpaRepository<Project,Integer> {

}
