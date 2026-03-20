package com.example.Gestion.des.livres.Repository;

import com.example.Gestion.des.livres.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}