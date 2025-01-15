package ru.gb.springdemo.web;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.gb.springdemo.model.Issue;
import ru.gb.springdemo.service.BookService;
import ru.gb.springdemo.service.IssueService;
import ru.gb.springdemo.service.ReaderService;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class IssueController {
    /**
     * Структура данных для передачи в шаблон thymeleaf
     */
    @Getter
    static class ReturnStructure {
        public String book;
        public String reader;
        public String dateIssueAt;
        public String dateReturnedAt;

        public ReturnStructure(String book, String reader, String dateIssueAt, String dateReturnedAt) {
            this.book = book;
            this.reader = reader;
            this.dateIssueAt = dateIssueAt;
            this.dateReturnedAt = dateReturnedAt;
        }
    }

    @Autowired
    IssueService issueService;
    @Autowired
    ReaderService readerService;
    @Autowired
    BookService bookService;

    @GetMapping("/ui/issues")
    public String issues(Model model) {

        /**
         * Для форматирования даты выдачи и даты возврата книги
         * в читаемый вид
         */
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd", Locale.ENGLISH);
        Issue[] allIssues = issueService.getAllIssues();
        List<ReturnStructure> returnStructures = new ArrayList<>();

        for (Issue issue : allIssues) {
            returnStructures.add(
                    new ReturnStructure(
                            bookService.bookInfo(issue.getBookId()).getName()
                            , readerService.ReaderInfo(issue.getReaderId()).getName()
                            , issue.getIssuedAt() == null ? "" : ZonedDateTime.of(issue.getIssuedAt(), ZoneId.of("Europe/Moscow")).format(formatter)
                            , issue.getReturnedAt() == null ? "" : ZonedDateTime.of(issue.getReturnedAt(), ZoneId.of("Europe/Moscow")).format(formatter))
            );
        }

        model.addAttribute("items", returnStructures);
        return "issues";
    }
}
