package com.ravi.runner;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ravi.entity.Author;
import com.ravi.entity.Book;
import com.ravi.repository.IAuthorRepository;
import com.ravi.service.IBookService;

@Component
public class BookRunner implements CommandLineRunner {

	@Autowired
	IBookService service;
	
	@Autowired
	IAuthorRepository authorRepository;
	
	Scanner sc=new Scanner(System.in);
	
	@Override
	public void run(String... args) throws Exception {
		try {
			
			while(true) {
				
				System.out.println("1.Insert author and Book.");
				System.out.println("2.Select Books with author.");
				System.out.println("3.Delete Book");
				System.out.println("4.Exit.");
				System.out.println("=====================");
				System.out.println("Select your choice.");
				int choice=Integer.parseInt(sc.nextLine());
				
				switch(choice) {
				
				case 1->{
					
					System.out.print("How many author u want to save/insert: ");
					int noOfAuthor=Integer.parseInt(sc.nextLine());
					
					for(int i=1;i<=noOfAuthor;i++) {
						
						System.out.print("enter author"+i+" name: ");
						String name=sc.nextLine();
						
						System.out.print("enter author"+i+" country: ");
						String country=sc.nextLine();
						
						Author author=new Author(name, country);
						Author save = authorRepository.save(author);
						
							System.out.println("enter number of books that u want to insert: ");
							
							int noOfBooks=Integer.parseInt(sc.nextLine());
							
							int count=0;
							
							for(int j=1;j<=noOfBooks;j++) {
								count++;
								System.out.print("enter book"+j+" title: ");
								String title=sc.nextLine();
								
								System.out.print("enter book"+j+" genre: ");
								String genre=sc.nextLine();
								
								Book book=new Book(title, genre);
								book.setAuthor(save);
							
								service.saveBookAndAuthor(book);				
							}
							
							System.out.println(count+" books save successfully.");
					}
					System.out.println("=============================");
					
				}
				
				case 2->{
					List<Book> showAllBooksWithAuthor = service.showAllBooksWithAuthor();
					showAllBooksWithAuthor.forEach(book->{
						System.out.print("Id: "+book.getId()+"  ");
						System.out.print("Title: "+book.getTitle()+"  ");
						System.out.print("Genre: "+book.getGenre()+"  ");
						System.out.println("Author: "+book.getAuthor().getName()+"  ");
					});
					System.out.println("=============================");
				}
				
				case 3->{
					System.out.print("enter book id: ");
					int id=Integer.parseInt(sc.nextLine());
					
					String removeBookById = service.removeBookById(id);
					System.out.println(removeBookById);
					System.out.println("=================================");
				}
				
				case 4->{
					System.out.println("Thankyou.....");
					System.exit(0);
				}

				}	
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
