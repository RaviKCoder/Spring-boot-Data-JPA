package com.ravi.service;

import java.util.List;

import com.ravi.entity.Book;

public interface IBookService {

	public String saveBookAndAuthor(Book book);
	public List<Book> showAllBooksWithAuthor();
	public String removeBookById(Integer id);
	
}
