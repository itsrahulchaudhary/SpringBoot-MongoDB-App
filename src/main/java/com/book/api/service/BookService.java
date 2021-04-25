package com.book.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.api.entity.Book;
import com.book.api.repository.BookRepository;
 

@Service
public class BookService {
	
	
	@Autowired
	private BookRepository bookRepository;
	
	public Book saveBook(Book book) {
		 return bookRepository.save(book);
	}
	
	public List<Book> saveBooks(List<Book> books){
		return bookRepository.saveAll(books);
	}
	
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}

	public Book getBookById(int id) {
		return bookRepository.findById(id).orElse(null);
	}
	
	public Book getBookByName(String name) {
		return bookRepository.findByName(name);
	}
	
	public String deleteBook(int id) {
		bookRepository.deleteById(id);
		return "Product deleted successfully : "+id;
	}
	
	public Book updateBook(Book book) {
		Book existingProduct = bookRepository.findById(book.getId()).orElse(null);
		 existingProduct.setName(book.getName());
		 existingProduct.setAuther(book.getAuther());
		 return bookRepository.save(existingProduct);
	}
	

}
