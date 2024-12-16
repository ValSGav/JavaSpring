package org.example.config;

import org.example.domain.Car;
import org.example.domain.Engine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages =  "org.example.domain")
public class ProjectConfig {


//    @Bean
//    Engine engin(){
//        Engine eng = new Engine();
//        return eng;
//    }
//    @Bean("bmw")
//    Car car() {
//        Car obCar = new Car();
//        obCar.setCarEngine( engin() );
//        obCar.setModel( "X1" );
//        obCar.setMade( "BMW" );
//        return obCar;
//    }
//
//    @Bean("audi")
//    Car car1() {
//        Car obCar = new Car();
//        obCar.setCarEngine( engin() );
//        obCar.setModel( "Audi" );
//        obCar.setMade( "Q8" );
//        return obCar;
//    }
//
//    @Bean
//    @Primary
//    Car car2() {
//        Car obCar = new Car();
//        obCar.setCarEngine( engin() );
//        obCar.setModel( "H7" );
//        obCar.setMade( "Havale" );
//        return obCar;
//    }
//
//    @Bean(name = "renault")
//    Car car3() {
//        Car obCar = new Car();
//        obCar.setCarEngine( engin() );
//        obCar.setModel( "Logan" );
//        obCar.setMade( "Renault" );
//        return obCar;
//    }

    @Bean
    String hello(){
        return "Hello";
    }

    @Bean
    Integer ten(){
        return 10;
    }

}
