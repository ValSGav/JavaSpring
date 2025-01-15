package ru.gb.springdemo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.gb.springdemo.service.IssueService;
import ru.gb.springdemo.service.ReaderService;

@Controller
public class ReaderController {
    @Autowired
    ReaderService readerService;
    @Autowired
    IssueService issueService;

    @GetMapping("/ui/readers")
    public String readers(Model model) {
        model.addAttribute("items", readerService.getAllReaders());
        return "readers";
    }

    @GetMapping("ui/readers/{id}")
    public String readersById(@PathVariable("id") long id, Model model) {
        model.addAttribute("userId", id);
        model.addAttribute("userName", readerService.ReaderInfo(id).getName());
        model.addAttribute("books", issueService.issueReturnBookByUserId(id));
        return "readers_info";
    }
}
