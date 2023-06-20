package serviceimpl;

import db.DataBase;
import model.Contact;
import model.Phone;
import service.ContactService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class ContactServiceIMPL implements ContactService {
    private DataBase dataBase;



    public ContactServiceIMPL(DataBase dataBase) {
        this.dataBase = dataBase;
    }
    public ContactServiceIMPL(){

    }

    @Override
    public void addContactToPhone(Long phoneId,List<Contact>contacts) {
        for (Phone p:dataBase.getPhones()) {
            if(p.getId().equals(phoneId)){
                p.setContactList(contacts);

            }


        }
    }

    @Override
    public Contact findContactByName(Long phoneId, String contactName) {
        List<Phone> phones = dataBase.getPhones().stream().filter(phone -> phone.getId().equals(phoneId)).toList();
        List<Contact> contacts2 = phones.get(0).getContactList().stream().filter(contact -> contact.getName().equals(contactName)).toList();
        return contacts2.get(0);
    }

    @Override
    public Contact findContactByPhoneNumber(Long phoneId, Long phoneNumber) {
        List<Phone>phones=dataBase.getPhones().stream().filter(phone -> phone.getId().equals(phoneId)).toList();
        List<Contact>contacts1 = phones.get(0).getContactList().stream().filter(contact -> contact.getPhoneNumber().equals(phoneNumber)).toList();
        return contacts1.get(0);
    }

    @Override
    public List<Contact> sortContactsByName(Long phoneId) {
        List<Phone> phones = dataBase.getPhones().stream().filter(phone -> phone.getId().equals(phoneId)).toList();
        List<Contact>contacts1 = phones.get(0).getContactList().stream()
                .sorted(Comparator.comparing(Contact::getName)).toList();
        return contacts1;
    }

    @Override
    public void deleteContactByNameFromPhone(Long phoneId, String contactName) {
        List<Phone> phones = dataBase.getPhones().stream().filter(phone -> phone.getId().equals(phoneId)).toList();
         phones.get(0).getContactList().removeIf(contact -> contact.getName().equals(contactName));
        System.out.println(phones+"Contact is successfully deleted!");
    }
}
