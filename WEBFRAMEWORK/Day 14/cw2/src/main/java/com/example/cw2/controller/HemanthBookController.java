package com.example.cw2.controller;

import com.example.cw2.model.HemanthBook;
import com.example.cw2.service.HemanthBookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class HemanthBookController {
    private final HemanthBookService bookService;

    public HemanthBookController(HemanthBookService BookService) {
        this.bookService = BookService;
    }

    @PostMapping
    public ResponseEntity<HemanthBook> createBook(@RequestBody HemanthBook Book) {
        HemanthBook createdBook = bookService.createBook(Book);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }

    @GetMapping
    public ResponseEntity<List<HemanthBook>> getAllBooks() {
        List<HemanthBook> Books = bookService.getAllBooks();
        return ResponseEntity.ok(Books);
    }
    @PutMapping("/{bookId}")
    public HemanthBook updateBookById(@PathVariable Long bookId,@RequestBody HemanthBook book){
        HemanthBook b = bookService.updateBookById(bookId, book);
        return b;
    }
    @GetMapping("/{bookId}")
    public HemanthBook getBookById(@PathVariable Long bookId) {
        HemanthBook book = bookService.getBookById(bookId);
        return book;
    }
}
