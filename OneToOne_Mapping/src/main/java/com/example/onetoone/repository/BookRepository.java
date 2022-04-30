package com.example.onetoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onetoone.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

}
