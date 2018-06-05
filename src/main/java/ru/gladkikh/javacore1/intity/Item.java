package ru.gladkikh.javacore1.intity;

public class Item {
    String surname;
    String phone;

    public Item(String surname, String phone) {
        this.surname = surname;
        this.phone = phone;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }
}