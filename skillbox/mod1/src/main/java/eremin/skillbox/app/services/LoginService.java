package eremin.skillbox.app.services;

import eremin.skillbox.web.dto.LoginForm;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private Logger logger = Logger.getLogger(LoginService.class);

    public boolean authenticate(LoginForm loginFrom) {
        logger.info("try auth with user-form: " + loginFrom);
        return loginFrom.getUsername().equals("root") && loginFrom.getPassword().equals("123");
    }
}
