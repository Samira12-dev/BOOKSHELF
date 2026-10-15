package com.example.BOOKSHELF.repo;

import com.example.BOOKSHELF.entity.Book;
import com.example.BOOKSHELF.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book,Long> {
    List<Book> findByAuteur(String auteur);
    List<Book> findByStatus(Status status);
    List<Book> findByTitreIsContainingIgnoreCase(String titre);

}
