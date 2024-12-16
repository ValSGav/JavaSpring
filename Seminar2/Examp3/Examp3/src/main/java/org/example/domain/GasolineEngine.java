package org.example.domain;

import org.springframework.stereotype.Component;
@Component
public class GasolineEngine implements iEngine{
    @Override
    public void startEngine() {
        System.out.println("Запущен бензин");
    }
}
