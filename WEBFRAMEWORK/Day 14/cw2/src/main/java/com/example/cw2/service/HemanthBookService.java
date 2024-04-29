package com.example.cw2.service;

import com.example.cw2.model.HemanthBook;
import com.example.cw2.repository.HemanthBookRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HemanthBookService {
    private final HemanthBookRepo bookRepo;

    public HemanthBookService(HemanthBookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public HemanthBook createBook(HemanthBook Book) {
        return bookRepo.save(Book);
    }
    public List<HemanthBook> getAllBooks() {
        return bookRepo.findAll();
    }
    public HemanthBook getBookById(Long id) {
        return bookRepo.findById(id).orElse(null);
    }
    public HemanthBook updateBookById(Long id,HemanthBook book){
        HemanthBook b = bookRepo.findById(id).orElse(null);
        if(b!=null){
            b.setAuthor(book.getAuthor());
            b.setAvailableCopies(book.getAvailableCopies());
            b.setTitle(book.getTitle());
            b.setTotalCopies(book.getTotalCopies());
            bookRepo.save(b);
        }
        return b;
    }
}
