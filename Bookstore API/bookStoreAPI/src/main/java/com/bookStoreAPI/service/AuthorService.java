package com.bookStoreAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bookStoreAPI.entity.Author;
import com.bookStoreAPI.exception.AuthorIdNotFoundExeption;
import com.bookStoreAPI.repository.AuthorRepository;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Optional<Author> getAuthorById(Long id) {
    	Optional<Author> author =authorRepository.findById(id);
    	if(author.isPresent()) {
    		return authorRepository.findById(id);
    	}
    	else {
    		throw new AuthorIdNotFoundExeption();
    	}
    }

    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Author updateAuthor(Long id, Author updatedAuthor) {
        return authorRepository.findById(id)
                .map(author -> {
                    author.setName(updatedAuthor.getName());
                    return authorRepository.save(author);
                })
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}

