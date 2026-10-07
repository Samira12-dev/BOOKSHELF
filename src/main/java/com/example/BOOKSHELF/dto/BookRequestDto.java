package com.example.BOOKSHELF.dto;

import com.example.BOOKSHELF.enums.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class BookRequestDto {
    @NotBlank(message = "titre est obligatoire")
    private String titre;
    @NotBlank(message = "auteur est obligatoire")
    private String auteur;
    @NotBlank(message = "isbn est obligatoire")
    private String isbn;
    @NotBlank(message = "category est obligatoire")
    private String category;
    @NotNull(message = "status est obligatoire")
    private Status status;


}

