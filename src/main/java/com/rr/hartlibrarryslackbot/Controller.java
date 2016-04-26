package com.rr.hartlibrarryslackbot;

import com.rr.hartlibrarryslackbot.data.BookDb;
import com.rr.hartlibrarryslackbot.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rewati Raman(rewati.raman@gmail.com).
 */
@ComponentScan
@RestController
@EnableAutoConfiguration
@RequestMapping("/books")
public class Controller {
    private final String BookFound = "#UserName# searched for ISBN #ISBN# .\n This book is available at Hart Library.";

    @Autowired
    BookDb bookDb;

    @RequestMapping("")
    String checkDbForBook(@RequestBody String msg) {
        System.out.println(msg);
        Map<String, String> msgMap = splitToMap(msg);
        return null;
    }

    String checkDbForBookTest(@RequestBody String msg) {
        System.out.println(msg);
        Map<String, String> msgMap = splitToMap(msg);
        String returnMsg = BookFound.replaceAll("#UserName#",msgMap.get("user_name"));

        return returnMsg;
    }

    public static void main(String arg[]) {
        SpringApplication.run(Controller.class,arg);
    }

    private Map<String, String> splitToMap(String str) {
        String[] tokens = str.split("&");
        Map<String, String> map = new HashMap<String, String>();
        for (int i=0; i<tokens.length-1; ++i ) {
            String[] keyValue = tokens[i].split("=");
            map.put(keyValue[0],keyValue[1]);
        }
        return map;
    }


}
