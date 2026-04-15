package com.ttf.controller;

import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class HomeController {

    @GetMapping("")
    public String getMethodName(Model m) throws IOException {
        log.info("entato nella home");
        m.addAttribute("username", "Giulio");
        return "viwe-home";
    }
}
