package com.book.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.book.api.entity.Book;
import com.book.api.service.BookService;

 

@RestController
public class BookController {
	

	@Autowired
	private BookService bookService;
	
	@PostMapping("/addBook")
	public Book addBook(@RequestBody Book book) {
		return bookService.saveBook(book);
	}
	
	@PostMapping("/addBooks")
	public List<Book> addBooks(@RequestBody List<Book> books){
		return bookService.saveBooks(books);
	}
	
	@GetMapping("/getAllBooks")
	public List<Book> findAllBooks(){
		return bookService.getAllBooks();
	}

	@GetMapping("/getBookById/{id}")
	public Book findBookById(@PathVariable int id) {
		return bookService.getBookById(id);
	}
	
	@GetMapping("/getBookByName/{name}")
	public Book findByName(@PathVariable String name) {
		return bookService.getBookByName(name);
	}
	
	@PutMapping("/updateBook")
	public Book updateBook(@RequestBody Book book) {
		return bookService.updateBook(book);
	}
	
	@DeleteMapping("delete/{id}")
	public String deleteById(@PathVariable int id) {
		return bookService.deleteBook(id);
	}

}
