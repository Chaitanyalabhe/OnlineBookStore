package com.example.onlinebookstore;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private Context context;
    private List<Volume> volumeList; // List for API data
    private List<Volume> bookList;   // List for local app data

    // Constructor accepting both lists
    public BookAdapter(Context context, List<Volume> volumeList, List<Volume> bookList) {
        this.context = context;
        this.volumeList = volumeList;
        this.bookList = bookList;
    }

    public BookAdapter(ArrayList<Object> objects) {
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.book_item, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        if (bookList != null && !bookList.isEmpty()) {
            // Bind data for local Volume objects
            Volume book = bookList.get(position);
            VolumeInfo bookInfo = book.getVolumeInfo(); // VolumeInfo inside Volume

            holder.bookTitle.setText(bookInfo.getTitle());
            holder.bookAuthor.setText("Author: Unknown"); // Placeholder for missing author info

            Glide.with(context)
                    .load(bookInfo.getImageLinks() != null ? bookInfo.getImageLinks().getThumbnail() : "")
                    .placeholder(R.drawable.book_harrypotter3) // Placeholder for images
                    .into(holder.bookImage);

            // Click Listener to open BookDescriptionActivity
            holder.itemView.setOnClickListener(v -> {
                Intent intent = new Intent(context, BookDescription.class);
                intent.putExtra("bookName", bookInfo.getTitle());
                intent.putExtra("bookImage", bookInfo.getImageLinks() != null ? bookInfo.getImageLinks().getThumbnail() : "");
                intent.putExtra("bookRating", 4.5f); // Default rating for local app data
                intent.putExtra("bookPrice", "Not Available");
                intent.putExtra("bookDescription", bookInfo.getDescription());
                context.startActivity(intent);
            });

        } else if (volumeList != null && !volumeList.isEmpty()) {
            // Bind data for Volume objects (API data)
            Volume volume = volumeList.get(position);
            VolumeInfo volumeInfo = volume.getVolumeInfo(); // VolumeInfo inside Volume

            // Set Title
            holder.bookTitle.setText(volumeInfo.getTitle());

            // Set Author (if available)
            String author = (volumeInfo.getAuthors() != null && !volumeInfo.getAuthors().isEmpty())
                    ? volumeInfo.getAuthors().get(0)
                    : "Author: Unknown";
            holder.bookAuthor.setText(author);

            // Set Image
            if (volumeInfo.getImageLinks() != null) {
                String imageUrl = volumeInfo.getImageLinks().getThumbnail();
                Picasso.get()
                        .load(imageUrl)
                        .placeholder(R.drawable.book_harrypotter1) // Placeholder image
                        .into(holder.bookImage);
            } else {
                holder.bookImage.setImageResource(R.drawable.book_harrypotter1);
            }

            // Click Listener to open BookDescriptionActivity
            holder.itemView.setOnClickListener(v -> {
                Intent intent = new Intent(context, BookDescription.class);
                intent.putExtra("bookName", volumeInfo.getTitle());
                intent.putExtra("bookImage", volumeInfo.getImageLinks() != null ?
                        volumeInfo.getImageLinks().getThumbnail() : "");
                intent.putExtra("bookRating", 4.5f); // Default rating for API data
                intent.putExtra("bookPrice", "Not Available");
                intent.putExtra("bookDescription", volumeInfo.getDescription());
                context.startActivity(intent);
            });
        }
    }

    @Override
    public int getItemCount() {
        if (bookList != null && !bookList.isEmpty()) {
            return bookList.size();
        } else if (volumeList != null && !volumeList.isEmpty()) {
            return volumeList.size();
        }
        return 0;
    }

    // Update Volume data dynamically
    public void setVolumes(List<Volume> volumes) {
        this.volumeList = volumes;
        notifyDataSetChanged();
    }

    // Update Book data dynamically
    public void setBooks(List<Volume> books) {
        this.bookList = books;
        notifyDataSetChanged();
    }

    static class BookViewHolder extends RecyclerView.ViewHolder {
        ImageView bookImage;
        TextView bookTitle, bookAuthor;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            bookImage = itemView.findViewById(R.id.bookImageView);  // ImageView ID in book_item.xml
            bookTitle = itemView.findViewById(R.id.bookTitle);      // Title TextView ID
            bookAuthor = itemView.findViewById(R.id.bookAuthor);    // Author TextView ID
        }
    }
}