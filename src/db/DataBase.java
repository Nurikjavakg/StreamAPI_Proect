package db;

import model.Contact;
import model.Phone;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private List<Phone> phones = new ArrayList<>();

    public DataBase(List<Phone> phones) {
        this.phones = phones;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }
}

