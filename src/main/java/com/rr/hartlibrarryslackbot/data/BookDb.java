package com.rr.hartlibrarryslackbot.data;

import com.rr.hartlibrarryslackbot.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by Rewati Raman(rewati.raman@gmail.com).
 */
@Component
public class BookDb extends DB<Book> {

    @Autowired
    public BookDb(@Value("${db.file.loc}") String location) throws IOException {
        super(location);
    }
}
