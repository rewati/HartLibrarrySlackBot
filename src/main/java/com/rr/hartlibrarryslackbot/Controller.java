package com.rr.hartlibrarryslackbot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Rewati Raman(rewati.raman@gmail.com).
 */
@ComponentScan
@RestController
@EnableAutoConfiguration
public class Controller {

    @RequestMapping("/isbn/{isbn}")
    String home(@PathVariable String isbn){

        return isbn;
    }

    public static void main(String arg[]) {
        SpringApplication.run(Controller.class,arg);
    }
}
