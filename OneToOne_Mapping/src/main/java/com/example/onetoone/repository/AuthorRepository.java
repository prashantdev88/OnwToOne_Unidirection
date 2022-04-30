package com.example.onetoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onetoone.entity.Author;


@Repository
public interface AuthorRepository  extends JpaRepository<Author, Long>{

}
