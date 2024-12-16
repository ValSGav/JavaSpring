package org.example.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
    private String model = "BMW";
    private String made = "X1";
    @Autowired
    private iEngine carEngine;

    public Car(iEngine engine) {
        //this.carEngine = engine;
        System.out.println( "Автомобиль создан!" );
    }

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder( this )
                .append( "model", model )
                .append( "made", made )
                .toString();
    }

    public void setCarEngine(iEngine carEngine) {
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

    public void go() {
        carEngine.startEngine();
    }
}
