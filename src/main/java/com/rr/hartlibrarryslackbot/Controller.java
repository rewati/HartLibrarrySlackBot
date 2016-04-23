package com.rr.hartlibrarryslackbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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

    @RequestMapping("/isbn")
    String checkDbForBook(@RequestBody String msg) {
        Map<String, String> msgMap = splitToMap(msg);
        String returnMsg = msgMap.get("user_name")+" searched for ISBN "+msgMap.get("text")+" .\n";
        returnMsg = returnMsg + " This book is available at Hart Library.";
        return returnMsg;
    }

    public static void main(String arg[]) {
        SpringApplication.run(Controller.class,arg);
    }

    private Map<String, String> splitToMap(String str) {
        String[] tokens = str.split("\n");
        Map<String, String> map = new HashMap<String, String>();
        for (int i=0; i<tokens.length-1; ++i ) {
            String[] keyValue = tokens[i].split("=");
            map.put(keyValue[0],keyValue[1]);
        }
        return map;
    }
}
