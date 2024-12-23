package com.example.onlinebookstore;

public class ImageLinks {
    private String thumbnail;

//    public String getThumbnail() {
//        return thumbnail;
//    }

    public String getThumbnail() {
        if (thumbnail != null && !thumbnail.isEmpty()) {
            return thumbnail.replace("http://", "https://");
        }
        return null;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
