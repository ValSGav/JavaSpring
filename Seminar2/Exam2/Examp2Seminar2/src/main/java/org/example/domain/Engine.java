package org.example.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.stereotype.Component;

@Component
public class Engine {

    private String typeEngine = "Бензиновый";

    public Engine() {
        System.out.println("Двигатель создан!");
    }

    @Override
    public String toString() {
        return new ToStringBuilder( this )
                .append( "typeEngine", typeEngine )
                .toString();
    }

    public String getTypeEngine() {
        return typeEngine;
    }

    public void setTypeEngine(String typeEngine) {
        this.typeEngine = typeEngine;
    }
}
