package com.example.BOOKSHELF.service;

import com.example.BOOKSHELF.dto.BookRequestDto;
import com.example.BOOKSHELF.dto.BookResponseDto;
import com.example.BOOKSHELF.entity.Book;
import com.example.BOOKSHELF.enums.Status;

import java.time.LocalDate;
import java.util.List;

public interface BookService {
     BookResponseDto addBook(BookRequestDto dto);
     BookResponseDto updateBook(Long id, BookRequestDto dto);
     List<BookResponseDto> getAllBooks();
     BookResponseDto getBookById(Long id);
     void deleteBook(Long id);
     List<BookResponseDto> findByAuteur (String auteur);

     List<BookResponseDto> findByStatus();
     List<BookResponseDto> findByStatusAvailable();
     List<BookResponseDto> findByTitreIsContainingIgnoreCase(String titre);
}
