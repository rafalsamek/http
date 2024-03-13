package com.example.http.entry;

import com.example.http.Database;
import com.example.http.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

enum EntryStatus {
    NEW, IN_PROGRESS, DONE
}

class Entry {
    private Long id;
    private String name;
    private EntryStatus status;

    public Entry(Long id, String name, EntryStatus status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EntryStatus getStatus() {
        return status;
    }

    public void setStatus(EntryStatus status) {
        this.status = status;
    }
}

@RestController
@RequestMapping("/entry/entries")
public class EntryController {
    private Database<Long, Entry> database = new Database<>();
    private long lastId = 0;

    @GetMapping
    public List<Entry> list() {
        return database.list();
    }

    @GetMapping("/{id}")
    public Entry get(@PathVariable Long id) {
        Entry existing = database.get(id);

        if (existing == null) {
            throw new EntryNotFoundException(id);
        }

        return existing;
    }

    @PostMapping
    public Entry create(@RequestBody Entry entry) {
        entry.setId(++lastId);
        entry.setStatus(EntryStatus.NEW);
        return database.create(entry.getId(), entry);
    }

    @PutMapping
    public Entry update(@RequestBody Entry entry) {
        Entry existing = database.get(entry.getId());

        if (existing == null) {
            throw new EntryNotFoundException(entry.getId());
        }

        return database.update(entry.getId(), entry);
    }

    @PatchMapping
    public Entry updateStatus(@RequestBody Entry entry) {
        Entry existing = database.get(entry.getId());

        if (existing == null) {
            throw new EntryNotFoundException(entry.getId());
        }

        if (entry.getStatus() != null) {
            existing.setStatus(entry.getStatus());
        }

        return database.update(entry.getId(), existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        database.delete(id);
    }
}

@ResponseStatus(HttpStatus.NOT_FOUND)
class EntryNotFoundException extends NotFoundException {
    public EntryNotFoundException(Long id) {
        super("Entry with id " + id + " not found");
    }
}