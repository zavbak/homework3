package ru.gladkikh.javacore1.intity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PhoneBook {
    List<Item> items;

    public PhoneBook() {
        items = new ArrayList<>();
    }

    public void add(String surname,String phone){
        items.add(new Item(surname,phone));
    }

    public List<Item> get(String surname){
        return items.stream()
                .filter(item -> item.surname.equals(surname))
                .collect(Collectors.toList());
    }

}
