package com.ninjaproject.ninjaproject.controller;

import com.ninjaproject.ninjaproject.constant.ViewConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/contacts")
public class ContactController {

    @GetMapping("/contactForm")
    private String redirectContactForm() {
        return ViewConstant.CONTACT_FORM;
    }
}
