package org.example.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
    private String model = "BMW";
    private String made = "X1";
    @Autowired
    private Engine carEngine;

    public Car() {
        System.out.println("Автомобиль создан");
    }

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder( this )
                .append( "model", model )
                .append( "made", made )
                .append( "carEngine", carEngine )
                .toString();
    }

    public Engine getCarEngine() {
        return carEngine;
    }

    public void setCarEngine(Engine carEngine) {
        this.carEngine = carEngine;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMade() {
        return made;
    }

    public void setMade(String made) {
        this.made = made;
    }
}
