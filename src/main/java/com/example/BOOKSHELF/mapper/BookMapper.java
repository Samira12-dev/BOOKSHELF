package com.example.BOOKSHELF.mapper;

import com.example.BOOKSHELF.dto.BookRequestDto;
import com.example.BOOKSHELF.dto.BookResponseDto;
import com.example.BOOKSHELF.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BookMapper {

    Book toEntity(BookRequestDto requestDto);
    BookResponseDto toResponse(Book book);

    void updateBook(BookRequestDto requestDto, @MappingTarget Book book);
}
