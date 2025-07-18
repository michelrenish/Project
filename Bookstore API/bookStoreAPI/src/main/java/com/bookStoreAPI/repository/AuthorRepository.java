package com.bookStoreAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookStoreAPI.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
	
}
