package eremin.skillbox.web.controllers;

import eremin.skillbox.web.dto.LoginForm;
import org.apache.log4j.Logger;
import eremin.skillbox.app.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    private final Logger logger = Logger.getLogger(LoginController.class);
    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping
    public String login(Model model) {
        logger.info("GET /login returns login_page.html");
        model.addAttribute("loginForm", new LoginForm());
        return "login_page";
    }

    @PostMapping("/auth")
    public String authenticate(LoginForm loginFrom) {
        if (loginService.authenticate(loginFrom)) {
            logger.info("login ok redirect to book shelf");
            return "redirect:/books/shelf";
        } else {
            logger.info("login fail redirect to login");
            return "redirect:/login";
        }
    }
}
