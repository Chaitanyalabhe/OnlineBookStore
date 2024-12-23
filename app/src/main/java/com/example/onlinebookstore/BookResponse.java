package com.example.onlinebookstore;

import java.util.List;

public class BookResponse {
    private List<Volume> items;

    public List<Volume> getItems() {
        return items;
    }

    public void setItems(List<Volume> items) {
        this.items = items;
    }
}
