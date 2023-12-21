package com.example.bai2_springboot1.service;

import com.example.bai2_springboot1.model.Book;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    public List<Book> getAllBooksFromCSV() {
        List<Book> books = new ArrayList<>();

        try {
            ClassPathResource resource = new ClassPathResource("book.csv");
            InputStreamReader reader = new InputStreamReader(resource.getInputStream());

            // Sử dụng OpenCSV để đọc dữ liệu từ file CSV
            CSVReader csvReader = new CSVReader(reader);
            List<String[]> records = csvReader.readAll();

            for (String[] record : records) {
                Book book = new Book();
                book.setId(Integer.parseInt(record[0]));
                book.setName(record[1]);
                book.setDescription(record[2]);
                book.setAuthor(record[3]);
                book.setPublishYear(Integer.parseInt(record[4]));

                books.add(book);
            }

            csvReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }

        return books;
    }
}
