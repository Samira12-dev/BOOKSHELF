package com.example.BOOKSHELF.entity;

import com.example.BOOKSHELF.enums.Status;
import com.fasterxml.jackson.annotation.JsonTypeId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String titre;
    private String auteur;
    private String isbn;
    private String category;
    @Column(name = "date_ajout")
    private LocalDate dateAjout;
    @Enumerated(EnumType.STRING)
    private Status status;
}
