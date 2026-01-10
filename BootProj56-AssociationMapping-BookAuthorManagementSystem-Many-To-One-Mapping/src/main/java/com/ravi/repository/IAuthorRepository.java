package com.ravi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ravi.entity.Author;

public interface IAuthorRepository extends JpaRepository<Author, Integer> {

}
