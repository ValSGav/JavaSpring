package ru.gb.springdemo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.gb.springdemo.service.BookService;

@Controller
@Secu
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/ui/books")
    public String books(Model model) {
        model.addAttribute("items", (bookService.getAllBook()));
        return "books";
    }
}