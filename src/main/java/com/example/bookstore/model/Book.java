package com.example.bookstore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false, unique = true)
    private String isbn;
    @Column(nullable = false)
    private BigDecimal price;
    private String description;
    private String coverImage;

    public Book(final String title, final String author, final String isbn, final BigDecimal price,
            final String description, final String coverImage) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.description = description;
        this.coverImage = coverImage;
    }

    @Override
    public String toString() {
        return "Book{"
            + "id=" + id
            + ", title='" + title + '\''
            + ", author='" + author + '\''
            + ", isbn='" + isbn + '\''
            + ", price=" + price
            + ", description='" + description + '\''
            + ", coverImage='" + coverImage + '\''
            + '}';
    }
}
