package com.example.onetoone.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.onetoone.entity.Book;

import com.example.onetoone.repository.BookRepository;



@RestController
@RequestMapping(value = "book")
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	
	@PostMapping
	public Book addUserProfile(@RequestBody Book book) {
		bookRepository.save(book);
		return book;
	}
	
	@PutMapping("/{id}")
	public Book updateUserProfile(@PathVariable long id,@RequestBody Book book) {
		book.setId(id);
		bookRepository.save(book);
		return book;
	}
	
	@GetMapping
	public List<Book> getAllUserProfiles(){
		return bookRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Book getAllUserProfilesById(@PathVariable long id){
		Optional<Book> book = bookRepository.findById(id);
		return book.get();
	}
	
	@DeleteMapping("/{id}")
	public String deleteUserById(@PathVariable long id) {
		bookRepository.deleteById(id);
		return "DELETED "+id;
	}
}
