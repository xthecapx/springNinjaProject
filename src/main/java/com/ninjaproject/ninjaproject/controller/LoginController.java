package com.ninjaproject.ninjaproject.controller;

import com.ninjaproject.ninjaproject.model.UserCredential;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    public static final String LOGIN_VIEW = "login";

    @GetMapping("/")
    public String redirectToLogin() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public ModelAndView showLoginForm(@RequestParam(name = "error", required = false) String error,
                                      @RequestParam(name = "logout", required = false) String logout) {
        ModelAndView mav = new ModelAndView(LOGIN_VIEW);
        mav.addObject("userCredentials", new UserCredential());
        mav.addObject("error", error);
        mav.addObject("logout", logout);

        return mav;
    }

    @PostMapping("/logincheck")
    public String loginCheck(@ModelAttribute(name="userCredentials") UserCredential userCredential) {

        if (userCredential.getUsername().equals("user") && userCredential.getPassword().equals("user")) {
            return "contacts";
        } else {
            return "redirect:/login?error";
        }
    }
}
