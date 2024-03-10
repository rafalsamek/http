package com.example.http;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

class Animal {
    private Long id;
    private String name;
    private String kind;
    private Short age;

    public Animal(Long id, String name, String kind, Short age) {
        this.id = id;
        this.name = name;
        this.kind = kind;
        this.age = age;
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

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }
}

@RestController
public class ZooController {
    private Database<Long, Animal> database = new Database<>();
    private long lastId = 0;

    @GetMapping("/zoo/animals")
    public List<Animal> list() {
        return database.list();
    }

    @GetMapping("/zoo/animals/{id}")
    public Animal get(@PathVariable Long id) {
        Animal existing = database.get(id);

        if (existing == null) {
            throw new AnimalNotFound(id);
        }

        return existing;
    }

    @PostMapping("/zoo/animals")
    public Animal create(@RequestBody Animal animal) {
        animal.setId(++lastId);
        return database.create(animal.getId(), animal);
    }

    @PutMapping("/zoo/animals")
    public Animal update(@RequestBody Animal animal) {
        Animal existing = database.get(animal.getId());

        if (existing == null) {
            throw new AnimalNotFound(animal.getId());
        }

        return database.update(animal.getId(), animal);
    }

    @DeleteMapping("/zoo/animals/{id}")
    public void delete(@PathVariable Long id) {
        database.delete(id);
    }
}

@ResponseStatus(HttpStatus.NOT_FOUND)
class AnimalNotFound extends RuntimeException {
    public AnimalNotFound(Long id) {
        super("Animal with id " + id + " not found");
    }
}
