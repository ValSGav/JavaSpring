package ru.gb.springdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ru.gb.springdemo.service.RecoverExceptionTestService;
import ru.gb.springdemo.service.TimeMeasuringTestService;

@SpringBootApplication
@Slf4j
public class testAspect {


    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(testAspect.class, args);
        TimeMeasuringTestService myServiceBean = context.getBean(TimeMeasuringTestService.class);

        try {
            myServiceBean.testService();
        } catch (RuntimeException | InterruptedException e){
            log.info(e.toString());
        }

        RecoverExceptionTestService myServiceBean2 = context.getBean(RecoverExceptionTestService.class);
        try {


            System.out.println(Boolean.toString(myServiceBean2.test2()));
            System.out.println(myServiceBean2.test1());
        }catch (RuntimeException e){
            System.out.println(e.toString());
        };
        context.close();

    }
}
