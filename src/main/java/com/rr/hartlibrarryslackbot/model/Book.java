package com.rr.hartlibrarryslackbot.model;

import com.rr.hartlibrarryslackbot.data.InMemoDbObject;

/**
 * Created by Rewati Raman(rewati.raman@gmail.com).
 */
public class Book extends InMemoDbObject {
    private String isbn;
    private String name;
    private String publisher;
    private String description;
    private int pages;
    private String edition;

    public Book(String isbn,String name,String description) {
        this.isbn = isbn;
        this.name = name;
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }
}
