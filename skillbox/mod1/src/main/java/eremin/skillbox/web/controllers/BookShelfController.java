package eremin.skillbox.web.controllers;

import org.apache.log4j.Logger;
import eremin.skillbox.app.services.BookService;
import eremin.skillbox.web.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/books")
public class BookShelfController {

    private Logger logger = Logger.getLogger(BookShelfController.class);
    private BookService bookService;

    @Autowired
    public BookShelfController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/shelf")
    public String books(Model model) {
        logger.info("got book shelf");
        model.addAttribute("book", new Book());
        model.addAttribute("bookList", bookService.getAllBooks());
        return "book_shelf";
    }

    @PostMapping("/save")
    public String saveBook(Book book) {
        bookService.saveBook(book);
        logger.info("current repository size: " + bookService.getAllBooks().size());
        return "redirect:/books/shelf";
    }

    @PostMapping("/remove")
    public String removeBook(@RequestParam(value = "bookIdToRemove") Integer bookIdToRemove) {
        try{
            bookService.removeBookById(bookIdToRemove);
        }catch (Exception e){
            return "redirect:/books/shelf?error";
        }
        return "redirect:/books/shelf";
    }


    @PostMapping("/removeByRegex")
    public String removeByRegex(@RequestParam(value = "queryRegex") String queryRegex) {
        bookService.removeBookByRegex(queryRegex);
        return "redirect:/books/shelf";
    }
}
