package ru.gb.springdemo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.gb.springdemo.service.ReaderService;

import java.util.Arrays;

@Controller
public class ReaderController {

    @Autowired
    ReaderService readerService;


    @GetMapping("/ui/readers")
    public String readers(Model model) {
        model.addAttribute( "items"
                , Arrays.stream( readerService.getAllReaders() ).toList()
        );
        return "readers";
    }

}
