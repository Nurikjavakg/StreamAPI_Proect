package model;

import enums.Brand;

import java.util.List;

public class Phone {
    private Long id;
    private String name;
    private Brand brand;
    private List<Contact> contactList;

    public Phone(Long id, String name, Brand brand, List<Contact> contactList) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.contactList = contactList;
    }

    public Phone(Long id, String name, Brand brand) {
        this.id = id;
        this.name = name;
        this.brand = brand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    @Override
    public String toString() {
        return "\nPhone" +
                "id:" + id +
                " name:" + name +
                " brand:" + brand +
                " contactList:" + contactList;
    }
}
