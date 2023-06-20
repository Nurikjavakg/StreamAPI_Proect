package serviceimpl;

import db.DataBase;
import enums.Brand;
import model.Contact;
import model.Phone;
import service.PhoneService;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PhoneServiceIMPL implements PhoneService {
    private DataBase dataBase;

    public PhoneServiceIMPL(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String addPhone(List<Phone>phones) {
       dataBase.getPhones().addAll(phones);

        return "Successfully added phones!";
    }

    @Override
    public Phone getPhoneById(Long phoneId) {
        Stream<Phone>phoneStream = dataBase.getPhones().stream();
        List<Phone> phones = phoneStream.filter(phone -> phone.getId().equals(phoneId)).toList();
        return phones.get(0);
    }


    @Override
    public Phone updatePhoneNameById(Long phoneId, String newName) {
        Stream<Phone>phoneStream = dataBase.getPhones().stream();
        phoneStream.filter(phone -> phone.getId().equals(phoneId)).forEach(phone -> phone.setName(newName));
        return getPhoneById(phoneId);
    }

    @Override
    public List<Phone> getAllPhones() {

        return dataBase.getPhones().stream().toList();

    }

    @Override
    public List<Phone> getAllPhonesByBrand(Brand brand) {
        Stream<Phone>phoneStream = dataBase.getPhones().stream();
        List<Phone> phones = phoneStream.filter(phone -> phone.getBrand().equals(brand)).toList();
        return phones;
    }

    @Override
    public void deletePhoneById(Long phoneId) {
        List<Phone> phones = dataBase.getPhones();
        phones.removeIf(phone -> phone.getId().equals(phoneId));
        System.out.println("Phone is successfully deleted!");

    }
}
