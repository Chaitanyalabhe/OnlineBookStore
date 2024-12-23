package com.example.onlinebookstore;

import java.util.List;

public class VolumeInfo {
    private String title;                // Book Title
    private List<String> authors;        // List of Authors
    private String imageUrl;             // Book Cover URL
    private float rating;                // Rating of the Book
    private String price;                // Price of the Book
    private String description;          // Book Description
    private int pageCount;               // Page Count
    private String language;             // Language of the Book
    private ImageLinks imageLinks;       // Additional Image Links for the Book

    // Constructor
    public VolumeInfo(String title, List<String> authors, String imageUrl, float rating,
                String price, String description, int pageCount, String language, ImageLinks imageLinks) {
        this.title = title;
        this.authors = authors;
        this.imageUrl = imageUrl;
        this.rating = rating;
        this.price = price;
        this.description = description;
        this.pageCount = pageCount;
        this.language = language;
        this.imageLinks = imageLinks;
    }

    // Getter and Setter for Title (Truncates if > 13 characters)
    public String getTitle() {
        if (title != null && title.length() > 13) {
            return title.substring(0, 13) + "...";
        }
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter for Authors (As String)
    public String getAuthorsAsString() {
        if (authors != null && !authors.isEmpty()) {
            return String.join(", ", authors); // Combine authors into a single string
        }
        return "Unknown Author";
    }
    public List<String> getAuthors() {
        return authors;
    }
    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    // Getter and Setter for Image URL
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    // Getter and Setter for Rating
    public float getRating() {
        return rating;
    }
    public void setRating(float rating) {
        this.rating = rating;
    }

    // Getter and Setter for Price
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

    // Getter and Setter for Description
    public String getDescription() {
        return description != null ? description : "No description available.";
    }
    public void setDescription(String description) {
        this.description = description;
    }

    // Getter and Setter for Page Count
    public int getPageCount() {
        return pageCount;
    }
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    // Getter and Setter for Language
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }

    // Getter and Setter for ImageLinks
    public ImageLinks getImageLinks() {
        return imageLinks;
    }
    public void setImageLinks(ImageLinks imageLinks) {
        this.imageLinks = imageLinks;
    }
}