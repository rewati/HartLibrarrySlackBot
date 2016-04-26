package com.rr.hartlibrarryslackbot.services;

import com.rr.hartlibrarryslackbot.model.Book;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Rewati Raman(rewati.raman@gmail.com).
 */
public class BookServicesImlTest {

    private BookServices bookServices = new BookServicesIml();

//    @Test
    public void insert() throws Exception {
        Book book = new Book("test","Test bOOk Name","Test description");
        book.setPages(400);
        bookServices.insert(book);
    }

//    @Test
    public void search() throws Exception {
        Book book = bookServices.search("test");
        Assert.assertNotNull(book);
        Assert.assertEquals("test",book.getIsbn());
    }
}