package com.rr.hartlibrarryslackbot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Rewati Raman(rewati.raman@gmail.com).
 */

@Configuration
public class InMemoryDb {

    @Value("db.file.loc")
    private String dbFileLocation;
    private static InMemoryDb inMemoryDb;
    private InMemoryDb(){
        
    }
}
