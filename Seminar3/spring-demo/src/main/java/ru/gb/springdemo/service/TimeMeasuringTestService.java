package ru.gb.springdemo.service;

import org.springframework.stereotype.Service;
import ru.gb.springdemo.aspect.TimeMeasured;

import java.util.concurrent.TimeUnit;

@Service
@TimeMeasured
public class TimeMeasuringTestService {
    public void testService() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
    };
}
