package com.ninjaproject.ninjaproject.controller;

import com.ninjaproject.ninjaproject.constant.ViewConstant;
import com.ninjaproject.ninjaproject.model.UserCredential;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    private static final Log LOGGER = LogFactory.getLog(LoginController.class);

    @GetMapping("/")
    public String redirectToLogin() {
        LOGGER.info("method redirectToLogin()");
        return "redirect:/login";
    }

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

    @PostMapping("/logincheck")
    public String loginCheck(@ModelAttribute(name="userCredentials") UserCredential userCredential) {

        LOGGER.info("method loginCheck() userCredential: " + userCredential.toString());

        if (userCredential.getUsername().equals("user") && userCredential.getPassword().equals("user")) {
            return ViewConstant.CONTACTS;
        } else {
            return "redirect:/login?error";
        }
    }
}
