package ru.gb.spring_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDemoApplication {

	/*
	tomcat - контейнер сервлетов(специальные объекты) (упрощенно веб-сервер на какой-то машине)
	spring-web.jar - все пути сконфигурированные в спринг приложении обрабатываются tomcat-ом
	*/


	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}

}
