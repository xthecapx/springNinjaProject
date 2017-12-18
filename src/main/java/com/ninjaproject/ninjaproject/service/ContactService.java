package com.ninjaproject.ninjaproject.service;

import com.ninjaproject.ninjaproject.entity.Contact;
import com.ninjaproject.ninjaproject.model.ContactModel;

import java.util.List;

public interface ContactService {

    public abstract ContactModel addContact(ContactModel contactModel);
    public abstract List<ContactModel> listAllContacts();
    public abstract Contact findContactById(int id);
    public abstract void removeContact(int id);
    public abstract ContactModel findContactModelById(int id);
}
