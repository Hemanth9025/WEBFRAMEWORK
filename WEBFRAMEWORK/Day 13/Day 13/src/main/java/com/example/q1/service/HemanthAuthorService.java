package com.example.q1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.q1.model.HemanthAuthor;
import com.example.q1.repository.HemanthAuthorRepository;

@Service
public class HemanthAuthorService {
    @Autowired
    private HemanthAuthorRepository authorRepository;

    public HemanthAuthor saveAuthor(HemanthAuthor author) {
        return authorRepository.save(author);
    }

    public HemanthAuthor getAuthorById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    public List<HemanthAuthor> getAllAuthors() {
        return authorRepository.findAll();
    }

    public HemanthAuthor updateAuthor(Long id, HemanthAuthor author) {
        HemanthAuthor existingAuthor = authorRepository.findById(id).orElse(null);
        if (existingAuthor != null) {
            existingAuthor.setEmail(author.getEmail());
            existingAuthor.setPhoneNumber(author.getPhoneNumber());
            existingAuthor.setAddress(author.getAddress());
            return authorRepository.save(existingAuthor);
        }
        return null;
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
