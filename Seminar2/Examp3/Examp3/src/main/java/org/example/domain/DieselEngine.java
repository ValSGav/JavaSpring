package org.example.domain;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class DieselEngine implements iEngine{

    @Override
    public void startEngine() {
        System.out.println("Запущен дизель");
    }
}
