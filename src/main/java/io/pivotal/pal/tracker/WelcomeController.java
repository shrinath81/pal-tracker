package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class WelcomeController {
    private String env;


    public WelcomeController(@Value("${WELCOME_MESSAGE}") String env) {
        this.env = env;
        //System.out.println(env);

    }


    @GetMapping("/")


    public String sayHello() {
        //this.env = env;

        return this.env;
    }
}
