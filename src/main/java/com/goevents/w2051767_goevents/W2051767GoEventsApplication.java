package com.goevents.w2051767_goevents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class W2051767GoEventsApplication {

    public static void main(String[] args) {
        SpringApplication.run(W2051767GoEventsApplication.class, args);

        //System.out.println("Hello world");

    }

}
