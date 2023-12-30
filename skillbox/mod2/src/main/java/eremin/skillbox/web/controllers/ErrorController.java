package eremin.skillbox.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

    @GetMapping("/404")
    public String notFoundError() {
        return "errors/404";
    }
    @GetMapping("/204")
    public String noContent() {
        return "errors/204";
    }

}
