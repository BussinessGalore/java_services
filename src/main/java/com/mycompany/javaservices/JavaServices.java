/*
 * This file is the main class.
 * 
 * @author Catalina Ariza and Julian Celis
 */

package com.mycompany.javaservices;

import java.io.IOException;
import java.net.MalformedURLException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaServices {

    public static void main(String[] args) throws MalformedURLException, IOException {
        SpringApplication.run(JavaServices.class, args);
    }
}
