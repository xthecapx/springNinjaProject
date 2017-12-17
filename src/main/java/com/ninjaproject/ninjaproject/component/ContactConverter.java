package com.ninjaproject.ninjaproject.component;

import com.ninjaproject.ninjaproject.entity.Contact;
import com.ninjaproject.ninjaproject.model.ContactModel;
import org.springframework.stereotype.Component;

@Component("contactConverter")
public class ContactConverter {
    public Contact contactModel2Contact(ContactModel contactModel) {
        Contact contact = new Contact();
        contact.setCity(contactModel.getCity());
        contact.setFirstname(contactModel.getFirstname());
        contact.setLastname(contactModel.getLastname());
        contact.setTelephone(contactModel.getTelephone());
        contact.setCity(contactModel.getCity());
        contact.setId(contactModel.getId());

        return contact;
    }

    public ContactModel contact2ContactModel(Contact contact) {
        ContactModel contactModel = new ContactModel();
        contactModel.setCity(contact.getCity());
        contactModel.setFirstname(contact.getFirstname());
        contactModel.setLastname(contact.getLastname());
        contactModel.setTelephone(contact.getTelephone());
        contactModel.setId(contact.getId());
        contactModel.setId(contact.getId());

        return contactModel;
    }
}
