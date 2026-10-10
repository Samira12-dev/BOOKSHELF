package com.example.BOOKSHELF.service;

import com.example.BOOKSHELF.dto.BookRequestDto;
import com.example.BOOKSHELF.dto.BookResponseDto;

import java.util.List;

public interface BookService {
    public BookResponseDto addBook(BookRequestDto dto);
    public BookResponseDto updateBook(Long id, BookRequestDto dto);
    public List<BookResponseDto> getAllBooks();
    public BookResponseDto getBookById(Long id);
    public void deleteBook(Long id);

}
