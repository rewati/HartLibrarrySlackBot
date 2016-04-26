package com.rr.hartlibrarryslackbot.services;

import com.rr.hartlibrarryslackbot.model.Book;

import java.io.IOException;

/**
 * Created by Rewati Raman(rewati.raman@gmail.com).
 */
public interface BookServices {
    void insert(Book book) throws IOException;
    Book search(String isbn) throws Exception;
}
