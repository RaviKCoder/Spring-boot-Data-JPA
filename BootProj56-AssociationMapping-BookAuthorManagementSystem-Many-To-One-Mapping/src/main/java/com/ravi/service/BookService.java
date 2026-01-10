package com.ravi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.entity.Book;
import com.ravi.repository.IBookRepository;

@Service
public class BookService implements IBookService {

	@Autowired
	IBookRepository repository;
	
	@Override
	public String saveBookAndAuthor(Book book) {
		Book save = repository.save(book);
		return "Book save successfully with id: "+save.getId();
	}

	@Override
	public List<Book> showAllBooksWithAuthor() {
		return repository.findAll();
	}

	@Override
	public String removeBookById(Integer id) {
		repository.deleteById(id);
		return "book deleted successfully by id: "+id;
	}

}
