package com.example.bookstore;

import com.example.bookstore.model.Book;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.service.BookService;
import java.math.BigDecimal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookStoreApplication.class, args);
    }

    @Bean
    CommandLineRunner init(BookService bookService) {
        return args -> {
            Book book1 = new Book(
                "Clean Code",
                "Robert C. Martin",
                "9780132350884",
                new BigDecimal("35.99"),
                "A handbook of agile software craftsmanship.",
                "clean-code.jpg"
            );

            Book book2 = new Book(
                "Effective Java",
                "Joshua Bloch",
                "9780134685991",
                new BigDecimal("42.50"),
                "Best practices for Java programming.",
                "effective-java.jpg"
            );

            Book savedBook1 = bookService.save(book1);
            Book savedBook2 = bookService.save(book2);
            bookService.findAll().forEach(System.out::println);
        };
    }


}
