package com.example.http;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database<ID, T> {
    private Map<ID, T> storage = new HashMap<>();

    public List<T> list() {
        return new ArrayList<>(storage.values());
    }

    public T get(ID id) {
        return storage.get(id);
    }

    public T create(ID id, T t) {
        storage.putIfAbsent(id, t);
        return t;
    }

    public T update(ID id, T t) {
        storage.put(id, t);
        return t;
    }

    public void delete(ID id) {
        storage.remove(id);
    }
}
