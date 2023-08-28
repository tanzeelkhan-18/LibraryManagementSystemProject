package com.libraryManagementSystem.model;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.jetbrains.annotations.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    @NotNull(message = "Book Title cannot be null")
    private String title;
    @NotNull(message = "Publish Year cannot be null")
    private int year;
    @NotNull(message = "ISBN cannot be null")
    private String isbn;
    @NotNull(message = "Available Numbers cannot be null")
    private int available;
    @ManyToOne(cascade = CascadeType.ALL)
    private Authors author;
    @ManyToOne(cascade = CascadeType.ALL)
    private Publishers publisher;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public Authors getAuthor() {
        return author;
    }

    public void setAuthor(Authors author) {
        this.author = author;
    }

    public Publishers getPublisher() {
        return publisher;
    }

    public void setPublisher(Publishers publisher) {
        this.publisher = publisher;
    }
}
