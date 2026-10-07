package com.example.BOOKSHELF.dto;

import com.example.BOOKSHELF.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDto {
    private Long id;
    private String titre;
    private String auteur;
    private String isbn;
    private String category;
    private LocalDate dateAjout;
    private Status status;
}
