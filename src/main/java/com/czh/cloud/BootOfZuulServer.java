package com.czh.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BootOfZuulServer {

    public static void main(String[] args) throws Exception {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("windows")) {
            System.setProperty("log.path", "D:/chenzhehao/workspace/czh");
        } else {
            System.setProperty("log.path", "/opt");
        }
        System.setProperty("context.name", "zuul-server");

        SpringApplication.run(BootOfZuulServer.class, args);
    }

}