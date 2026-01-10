package com.ravi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ravi.entity.Book;

public interface IBookRepository extends JpaRepository<Book, Integer> {

}
