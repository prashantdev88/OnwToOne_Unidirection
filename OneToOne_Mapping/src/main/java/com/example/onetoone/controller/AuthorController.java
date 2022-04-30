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

import com.example.onetoone.entity.Author;
import com.example.onetoone.repository.AuthorRepository;




@RestController
@RequestMapping(value = "author")
public class AuthorController {

	@Autowired
	private AuthorRepository authorRepository;
	
	@PostMapping
	public Author addAuthorProfile(@RequestBody Author author) {
		authorRepository.save(author);
		return author;
	}
	
	@PutMapping("/{id}")
	public Author updateAuthorProfile(@PathVariable long id,@RequestBody Author author) {
		author.setId(id);
		authorRepository.save(author);
		return author;
	}
	
	@GetMapping
	public List<Author> getAllAuthorProfiles(){
		return authorRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Author getAllAuthorProfilesById(@PathVariable long id){
		Optional<Author> authors = authorRepository.findById(id);
		return authors.get();
	}
	
	@DeleteMapping("/{id}")
	public String deleteAuthorById(@PathVariable long id) {
		authorRepository.deleteById(id);
		return "DELETED "+id;
	}
}
