package com.example.BOOKSHELF.service;

import com.example.BOOKSHELF.dto.BookRequestDto;
import com.example.BOOKSHELF.dto.BookResponseDto;
import com.example.BOOKSHELF.entity.Book;
import com.example.BOOKSHELF.exception.BookNotFoundException;
import com.example.BOOKSHELF.mapper.BookMapper;
import com.example.BOOKSHELF.repo.BookRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor

public class BookService {
    private final BookMapper mapper;
    private final BookRepo repo;

    @Transactional
    public BookResponseDto addBook(BookRequestDto dto){

        Book book = new Book();
        book.setTitre(dto.getTitre());
        book.setAuteur(dto.getAuteur());
        book.setIsbn(dto.getIsbn());
        book.setCategory(dto.getCategory());
        book.setStatus(dto.getStatus());
        book.setDateAjout(LocalDate.now());

        Book saved= repo.save(book);
        return mapper.toResponse(saved);
    }

    @Transactional
    public BookResponseDto updateBook(Long id, BookRequestDto dto){
        Book book =repo.findById(id).orElseThrow(()->new BookNotFoundException("Book not found"));
        mapper.updateBook(dto,book);
        return mapper.toResponse(book);
    }

    @Transactional
    public List<BookResponseDto>getAllBooks(){
        return repo.findAll().stream().map(mapper::toResponse).toList();
    }

    @Transactional
    public BookResponseDto getBookById(Long id){
        Book book =repo.findById(id).orElseThrow(()->new BookNotFoundException("Book not found"));
        return mapper.toResponse(book);
    }

    @Transactional
    public void deleteBook(Long id){
        Book book = repo.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found"));
        repo.delete(book);
    }
}
