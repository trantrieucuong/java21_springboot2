package com.example.bai2_springboot1.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {
    private Integer id;
    private String name;
    private String description;
    private String author;
    private Integer publishYear;
}
