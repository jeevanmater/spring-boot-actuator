package com.jeevankumar.com.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BOOK_MANAGEMENT")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "TITLE",nullable = false)
    private String title;
    @Column(name = "AUTHOR")
    private String author;
    @Column(name = "PRICE")
    private Double price;
}
