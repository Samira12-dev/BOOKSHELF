package com.example.BOOKSHELF.controller;

import com.example.BOOKSHELF.dto.BookRequestDto;
import com.example.BOOKSHELF.dto.BookResponseDto;
import com.example.BOOKSHELF.service.serviceImpl.BookServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

//    @GetMapping("/{auteur}")
//    public List<BookResponseDto>getAuteur(@PathVariable String auteur ){
//        return service.findByAuteur(auteur);
//    }

    @GetMapping("/borrowedBooks")
    public  List<BookResponseDto> getBooksBorrowed(){
        return  service.findByStatus();
    }
    @GetMapping("/availableBooks")
    public List<BookResponseDto> getAvailableBooks(){
        return  service.findByStatusAvailable();
    }

    @GetMapping("/titre")
    public  List<BookResponseDto> getByTitre(@RequestParam (name = "ti") String ti){
        return service.findByTitreIsContainingIgnoreCase(String.valueOf(ti));
    }

}

