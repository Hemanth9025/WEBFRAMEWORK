package com.example.q1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.q1.model.HemanthAuthor;
import com.example.q1.model.HemanthBook;
import com.example.q1.repository.HemanthAuthorRepository;
import com.example.q1.repository.HemanthBookRepository;

@Service
public class HemanthBookService {
    @Autowired
    private HemanthBookRepository bookRepository;
@Autowired
private HemanthAuthorRepository authorRepository;
    public HemanthBook saveBook(Long authorId, HemanthBook book) {
        HemanthAuthor author = authorRepository.findById(authorId).orElse(null);
        if (author != null) {
            book.setAuthor(author);
            author.getBooks().add(book);
            return bookRepository.save(book);
        }
        return null;
    }

    public HemanthBook getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}

