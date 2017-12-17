package com.ninjaproject.ninjaproject.controller;

import com.ninjaproject.ninjaproject.constant.ViewConstant;
import com.ninjaproject.ninjaproject.model.ContactModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/contacts")
public class ContactController {

    private static final Log LOGGER = LogFactory.getLog(ContactController.class);

    @GetMapping("/contactform")
    private String redirectContactForm(Model model) {
        model.addAttribute("contactModel", new ContactModel());
        return ViewConstant.CONTACT_FORM;
    }

    @GetMapping("/cancel")
    private String cancel() {
        return ViewConstant.CONTACTS;
    }

    @PostMapping("addcontact")
    private ModelAndView addContact(@ModelAttribute(name="contactModel") ContactModel contactModel) {
        LOGGER.info("addContact() -> " + contactModel.toString());
        ModelAndView mav = new ModelAndView(ViewConstant.CONTACTS);
        mav.addObject("contactModel", contactModel);
        mav.addObject("userAdded", 1);

        return mav;
    }
}
