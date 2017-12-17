package com.ninjaproject.ninjaproject.service.impl;

import com.ninjaproject.ninjaproject.component.ContactConverter;
import com.ninjaproject.ninjaproject.entity.Contact;
import com.ninjaproject.ninjaproject.model.ContactModel;
import com.ninjaproject.ninjaproject.repository.ContactRepository;
import com.ninjaproject.ninjaproject.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService {
    @Autowired
    @Qualifier("contactRepository")
    private ContactRepository contactRepository;

    @Autowired
    @Qualifier("contactConverter")
    private ContactConverter contactConverter;

    @Override
    public ContactModel addContact(ContactModel contactModel) {
        Contact contact = contactRepository.save(contactConverter.contactModel2Contact(contactModel));
        return contactConverter.contact2ContactModel(contact);
    }
}
