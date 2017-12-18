package com.ninjaproject.ninjaproject.controller;

import com.ninjaproject.ninjaproject.constant.ViewConstant;
import com.ninjaproject.ninjaproject.model.UserCredential;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    private static final Log LOGGER = LogFactory.getLog(LoginController.class);

    @GetMapping("/login")
    public ModelAndView showLoginForm(@RequestParam(name = "error", required = false) String error,
                                      @RequestParam(name = "logout", required = false) String logout) {

        LOGGER.info("method showLoginForm() error: " + error + " logout: " + logout);
        ModelAndView mav = new ModelAndView(ViewConstant.LOGIN);
        mav.addObject("userCredentials", new UserCredential());
        mav.addObject("error", error);
        mav.addObject("logout", logout);

        return mav;
    }

    @GetMapping({"/loginsuccess", "/"})
    public String loginCheck() {
        LOGGER.info("method loginCheck()");

        return "redirect:/contacts/showcontacts";
    }
}
