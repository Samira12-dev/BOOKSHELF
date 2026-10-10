package com.example.BOOKSHELF.controller;

import com.example.BOOKSHELF.dto.BookRequestDto;
import com.example.BOOKSHELF.dto.BookResponseDto;
import com.example.BOOKSHELF.service.BookServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookServiceImpl service;

    @PostMapping()
    public BookResponseDto addBook(@Valid @RequestBody BookRequestDto dto){
        return service.addBook(dto);
    }

    @PutMapping("/{id}")
    public BookResponseDto updateBook(@PathVariable Long id,@Valid @RequestBody BookRequestDto dto){
        return service.updateBook(id,dto);
    }

    @GetMapping("/{id}")
    public BookResponseDto getBookById(@PathVariable Long id){
        return service.getBookById(id);
    }

    @GetMapping
    public List<BookResponseDto>getAllBooks(){
        return service.getAllBooks();
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
       service.deleteBook(id);
    }
}
