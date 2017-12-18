package com.ninjaproject.ninjaproject.controller;

import com.ninjaproject.ninjaproject.constant.ViewConstant;
import com.ninjaproject.ninjaproject.entity.Contact;
import com.ninjaproject.ninjaproject.model.ContactModel;
import com.ninjaproject.ninjaproject.service.ContactService;
import com.sun.org.apache.xpath.internal.operations.Mod;
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
    private String redirectContactForm(@RequestParam(name="id", required = false) int id, Model model) {
        ContactModel contact = new ContactModel();

        if (id != 0) {
            contact = contactService.findContactModelById(id);
        }

        model.addAttribute("contactModel", contact);
        return ViewConstant.CONTACT_FORM;
    }

    @GetMapping("/cancel")
    private String cancel() {
        return "redirect:/contacts/showcontacts";
    }

    @PostMapping("addcontact")
    private ModelAndView addContact(@ModelAttribute(name="contactModel") ContactModel contactModel) {
        LOGGER.info("addContact() -> " + contactModel.toString());
        ModelAndView mav = new ModelAndView("redirect:/contacts/showcontacts");

        if (contactService.addContact(contactModel) != null) {
            mav.addObject("userAdded", "ADD");
        } else {
            mav.addObject("userAdded", "ERROR");
        }

        mav.addObject("contactModel", contactModel);


        return mav;
    }

    @GetMapping("/showcontacts")
    public ModelAndView showContacts(@RequestParam(name="userAdded", required = false, defaultValue = "") String userAdded) {
        ModelAndView mav = new ModelAndView(ViewConstant.CONTACTS);
        mav.addObject("userAdded", userAdded);
        mav.addObject("contacts", contactService.listAllContacts());

        return mav;
    }

    @GetMapping("/removecontact")
    public ModelAndView removeContact(@RequestParam(name="id") int id) {
        contactService.removeContact(id);

        return showContacts("DELETE");
    }
}
