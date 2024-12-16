package gb.ru.homework;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/homework")
    public String hello(){
        return "Привет! Это домашнее задание к семинару 2!";
    }
}
