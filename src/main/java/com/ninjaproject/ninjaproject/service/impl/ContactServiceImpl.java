package com.ninjaproject.ninjaproject.service.impl;

import com.ninjaproject.ninjaproject.component.ContactConverter;
import com.ninjaproject.ninjaproject.entity.Contact;
import com.ninjaproject.ninjaproject.model.ContactModel;
import com.ninjaproject.ninjaproject.repository.ContactRepository;
import com.ninjaproject.ninjaproject.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<ContactModel> listAllContacts() {
        List<Contact> contacts = contactRepository.findAll();
        List<ContactModel> contactModels = new ArrayList<ContactModel>();

        for (Contact contact : contacts) {
            contactModels.add(contactConverter.contact2ContactModel(contact));
        }

        return contactModels;
    }

    @Override
    public Contact findContactById(int id) {
        return contactRepository.findById(id);
    }

    @Override
    public ContactModel findContactModelById(int id) {
        return contactConverter.contact2ContactModel(findContactById(id));
    }

    @Override
    public void removeContact(int id) {
        Contact contact = findContactById(id);

        if (contact != null) {
            contactRepository.delete(contact);
        }
    }


}
