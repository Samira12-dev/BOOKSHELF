package com.example.BOOKSHELF.service.serviceImpl;

import com.example.BOOKSHELF.dto.BookRequestDto;
import com.example.BOOKSHELF.dto.BookResponseDto;
import com.example.BOOKSHELF.entity.Book;
import com.example.BOOKSHELF.enums.Status;
import com.example.BOOKSHELF.exception.BookNotFoundException;
import com.example.BOOKSHELF.mapper.BookMapper;
import com.example.BOOKSHELF.repo.BookRepo;
import com.example.BOOKSHELF.service.BookService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor

public class BookServiceImpl implements BookService {
    private final BookMapper mapper;
    private final BookRepo repo;

    @Override
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

    @Override
    @Transactional
    public BookResponseDto updateBook(Long id, BookRequestDto dto){
        Book book =repo.findById(id).orElseThrow(()->new BookNotFoundException("Book not found"));
        mapper.updateBook(dto,book);
        return mapper.toResponse(book);
    }

    @Override
    @Transactional
    public List<BookResponseDto>getAllBooks(){
        return repo.findAll().stream().map(mapper::toResponse).toList();
    }

    @Override
    @Transactional
    public BookResponseDto getBookById(Long id){
        Book book =repo.findById(id).orElseThrow(()->new BookNotFoundException("Book not found"));
        return mapper.toResponse(book);
    }

    @Override
    @Transactional
    public void deleteBook(Long id){
        Book book = repo.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found"));
        repo.delete(book);
    }
    @Override
    public List<BookResponseDto> findByAuteur (String auteur){
       List<Book>  books= repo.findByAuteur(auteur);
       return  books.stream().map(mapper::toResponse).toList();
    }

    @Override
    public List<BookResponseDto> findByStatus(){

        List<Book> booksBorrowed= repo.findByStatus(Status.BORROWED);
        return  booksBorrowed.stream().map(mapper::toResponse).toList();
    }

    @Override
    public List<BookResponseDto> findByStatusAvailable(){
        return repo.findByStatus(Status.AVAILABLE).stream()
                .map(mapper::toResponse).toList();
    }
  public List<BookResponseDto> findByTitreIsContainingIgnoreCase(String titre){
        List<Book> listBYTiitre= repo.findByTitreIsContainingIgnoreCase(titre);
        return  mapper.toDtoList(listBYTiitre);
  }



}
