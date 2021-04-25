package com.book.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.book.api.entity.Book;
 

public interface BookRepository extends MongoRepository<Book, Integer>{
	Book findByName(String name);

}
