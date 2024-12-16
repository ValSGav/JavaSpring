package org.example;

import org.example.config.ProjectConfig;
import org.example.domain.Car;
import org.example.domain.Engine;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext( ProjectConfig.class );
        Car c = context.getBean( Car.class );
        Engine e = context.getBean( Engine.class );
        System.out.println(c);
        System.out.println(e);
    }
}