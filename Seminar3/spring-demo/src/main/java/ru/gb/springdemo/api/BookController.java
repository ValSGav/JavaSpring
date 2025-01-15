package ru.gb.springdemo.api;

import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.gb.springdemo.model.Book;
import ru.gb.springdemo.service.BookService;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class BookController {

    @Autowired
    BookService bookService;
    @GetMapping("/ui/books")
    public String books(Model model){
        model.addAttribute( "items"
                , Arrays.stream( bookService.getAllBook() ).toList()
        );

        return "books";
    }
}
