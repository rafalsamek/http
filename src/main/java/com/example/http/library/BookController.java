package com.example.http.library;

import com.example.http.Database;
import com.example.http.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

enum Status {
    AVAILABLE,
    RESERVED,
    LENT
}

class Book {
    private long id;
    private String title;
    private String author;
    private Status status;

    public Book(long id, String title, String author, Status status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

@RestController
@RequestMapping("/library/books")
public class BookController {
    private Database<Long, Book> database = new Database<>();
    private long lastId = 0;

    @GetMapping
    public List<Book> list() {
        return database.list();
    }

    @GetMapping("/{id}")
    public Book get(@PathVariable Long id) {
        Book existing = database.get(id);

        if (existing == null) {
            throw new BookNotFoundException(id);
        }

        return existing;
    }
}

@ResponseStatus(HttpStatus.NOT_FOUND)
class BookNotFoundException extends NotFoundException {
    public BookNotFoundException(Long id) {
        super("Book with id " + id + " not found");
    }
}