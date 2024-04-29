package com.example.q1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.q1.model.HemanthAuthor;
import com.example.q1.model.HemanthBook;
import com.example.q1.service.HemanthAuthorService;
import com.example.q1.service.HemanthBookService;

@RestController
public class HemanthAuthorController {
    @Autowired
    private HemanthAuthorService authorService;
@Autowired
private HemanthBookService bookService;
    @PostMapping("/author")
    public ResponseEntity<HemanthAuthor> createAuthor(@RequestBody HemanthAuthor author) {
        HemanthAuthor savedAuthor = authorService.saveAuthor(author);
        return new ResponseEntity<>(savedAuthor, HttpStatus.CREATED);
    }

    @PostMapping("/book/author/{authorId}")
    public ResponseEntity<HemanthBook> createBookForAuthor(@PathVariable Long authorId, @RequestBody HemanthBook book) {
        HemanthBook savedBook = bookService.saveBook(authorId, book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @GetMapping("/author/{authorId}")
    public ResponseEntity<HemanthAuthor> getAuthorById(@PathVariable Long authorId) {
        HemanthAuthor author = authorService.getAuthorById(authorId);
        if (author != null) {
            return new ResponseEntity<>(author, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/author")
    public ResponseEntity<List<HemanthAuthor>> getAllAuthors() {
        List<HemanthAuthor> authors = authorService.getAllAuthors();
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @PutMapping("/author/{authorId}")
    public ResponseEntity<HemanthAuthor> updateAuthor(@PathVariable Long authorId, @RequestBody HemanthAuthor author) {
        HemanthAuthor updatedAuthor = authorService.updateAuthor(authorId, author);
        if (updatedAuthor != null) {
            return new ResponseEntity<>(updatedAuthor, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/book/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable Long bookId) {
        bookService.deleteBook(bookId);
        return new ResponseEntity<>("Book deleted successfully", HttpStatus.OK);
    }
}
