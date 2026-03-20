package com.example.Gestion.des.livres.Controller;

import com.example.Gestion.des.livres.Entity.Book;
import com.example.Gestion.des.livres.Repository.BookRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/books")
@CrossOrigin("*")
public class BookController {

    @Autowired
    private BookRepository repo;

    @GetMapping
    public List<Book> getAll(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null) ip = request.getRemoteAddr();
        log.info("GET /api/books - IP: {}", ip);
        return repo.findAll();
    }

    @PostMapping
    public Book add(@RequestBody Book book, HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null) ip = request.getRemoteAddr();
        log.info("POST /api/books - IP: {} - Titre: {}", ip, book.getTitle());
        return repo.save(book);
    }
}