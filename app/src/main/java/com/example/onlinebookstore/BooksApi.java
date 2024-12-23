package com.example.onlinebookstore;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BooksApi {

    @GET("volumes")
    Call<BookResponse> getBestsellers(
            @Query("q") String query, // "bestsellers"
            @Query("maxResults") int maxResults,
            @Query("key") String apiKey
    );

    @GET("volumes")
    Call<BookResponse> getNewest(
            @Query("q") String query, // "newest"
            @Query("orderBy") String order, // Example, like "newest" if supported by API
            @Query("maxResults") int maxResults,
            @Query("key") String apiKey
    );

    @GET("volumes")
    Call<BookResponse> getBooks(
            @Query("q") String query,
            @Query("maxResults") int maxResults,
            @Query("key") String apiKey
    );


}
