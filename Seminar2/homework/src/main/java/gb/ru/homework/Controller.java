package gb.ru.homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final GenerateStringService generateStringService;
    @GetMapping("/homework")
    public String saySomething(){
        return generateStringService.getSomeString();
    }
    @Autowired
    public Controller(GenerateStringService generateStringService) {
        this.generateStringService = generateStringService;
    }
}
