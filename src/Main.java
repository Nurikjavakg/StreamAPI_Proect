import db.DataBase;
import enums.Brand;
import model.Contact;
import model.Phone;
import serviceimpl.ContactServiceIMPL;
import serviceimpl.PhoneServiceIMPL;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Phone> phones = new ArrayList<>();



        DataBase dataBase = new DataBase(phones);
        PhoneServiceIMPL phoneServiceIMPL = new PhoneServiceIMPL(dataBase);
        ContactServiceIMPL contactServiceIMPL = new ContactServiceIMPL(dataBase);


        while (true){
            System.out.println("1.Add phone:\n"+
                    "2.Get phone by ID:\n"+
                    "3.Update phone name by ID:\n"+
                    "4.Get all phones:\"\n"+
                    "5.Get all phones by Brand:\n"+
                    "6.Get all phones by Brand:\n"+
                    "7.Add contact to phone:\n"+
                    "8.Find contact by name:\n"+
                    "9.Find contact by phone number:\n"+
                    "10.Sort contact by name:\n"+
                    "11.Delete contact by name:\n");


            int number = new Scanner(System.in).nextInt();

            switch (number) {

                case 1:
                    System.out.println("Add phone");
                    System.out.println(phoneServiceIMPL.addPhone( new ArrayList<>(
                            List.of(new Phone(1L, "Samsung", Brand.S18),
                                    new Phone(2L,"Iphone",Brand.XR),
                                    new Phone(3L,"Redmi",Brand.LS4)))));
                    break;
                case 2:
                    System.out.println("Get phone by ID:");
                    System.out.println(phoneServiceIMPL.getPhoneById(1L));
                    break;
                case 3:
                    System.out.println("Update phone name by ID:");
                    System.out.println(phoneServiceIMPL.updatePhoneNameById(1L, "Redmi"));
                    break;
                case 4:
                    System.out.println("Get all phones:");
                    System.out.println(phoneServiceIMPL.getAllPhones());
                    break;
                case 5:
                    System.out.println("Get all phones by Brand:");
                    System.out.println(phoneServiceIMPL.getAllPhonesByBrand(Brand.XR));
                    break;
                case 6:
                    System.out.println("Delete phone by ID:");
                    phoneServiceIMPL.deletePhoneById(14L);
                    break;
                case 7:
                    System.out.println("Add contact to phone:");
                    contactServiceIMPL.addContactToPhone(1L, new ArrayList<>(List.of(new Contact("Ronaldo",232L),new Contact("Messi",123L),new Contact("Benzema",342L))));
                    break;
                case 8:
                    System.out.println("Find contact by name:");
                    System.out.println(contactServiceIMPL.findContactByName(1L, "Ronaldo"));

                    break;
                case 9:
                    System.out.println("Find contact by phone number: ");
                    System.out.println(contactServiceIMPL.findContactByPhoneNumber(1L, 232L));
                    break;
                case 10:
                    System.out.println("Sort contact by name:");
                    System.out.println(contactServiceIMPL.sortContactsByName(1L));
                    break;
                case 11:
                    System.out.println("Delete contact by name:");
                    contactServiceIMPL.deleteContactByNameFromPhone(1L,"Messi");


            }
    }
    }
}