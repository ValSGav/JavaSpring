package org.example;

import org.example.config.ProjectConfig;
import org.example.domain.Car;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext( ProjectConfig.class)
                ;
        Car p = context.getBean( Car.class );
        p.go();

    }
}