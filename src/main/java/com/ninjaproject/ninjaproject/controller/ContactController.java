package com.ninjaproject.ninjaproject.controller;

import com.ninjaproject.ninjaproject.constant.ViewConstant;
import com.ninjaproject.ninjaproject.model.ContactModel;
import com.ninjaproject.ninjaproject.service.ContactService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/contacts")
public class ContactController {

    private static final Log LOGGER = LogFactory.getLog(ContactController.class);

    @Autowired
    @Qualifier("contactServiceImpl")
    private ContactService contactService;

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

        if (contactService.addContact(contactModel) != null) {
            mav.addObject("userAdded", 1);
        } else {
            mav.addObject("userAdded", 0);
        }

        mav.addObject("contactModel", contactModel);


        return mav;
    }
}
