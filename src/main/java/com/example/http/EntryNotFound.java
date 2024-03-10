package com.example.http;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
class EntryNotFound extends RuntimeException {
    public EntryNotFound(Long id) {
        super("Entry with id " + id + " not found");
    }
}
