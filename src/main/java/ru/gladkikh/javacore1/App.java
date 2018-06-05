package ru.gladkikh.javacore1;

import ru.gladkikh.javacore1.intity.PhoneBook;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Hello world!
 */
public class App {

    static String[] arrStrings;

    static PhoneBook myPhoneBook;

    static {
        arrStrings = new String[]{"Мама", "Мыла", "Раму", "Мы", "Дружно", "Пойдем",
                "Мама", "Мыла", "Раму", "Мы", "Дружно", "Пойдем",
                "Мама", "Мыла", "Раму", "Мы", "Дружно", "Пойдем",
                "Мама", "Мыла", "Раму", "Мы", "Дружно", "Пойдем", "Мама", "Мыла", "Раму", "Мы", "Дружно", "Пойдем"};


        myPhoneBook = new PhoneBook();
        myPhoneBook.add("Петров","+79142058362");
        myPhoneBook.add("Сидоров","+79142058345");
        myPhoneBook.add("Васичкин","+79142058326");
        myPhoneBook.add("Никитин","+79142058378");
        myPhoneBook.add("Петров","+79142058324");


    }

    public static void main(String[] args) {

        //Спрашивал у Александр Вдовенков о stream и rx, он сказал можно :)

        //Лень было делать fori можно было и distinct​() но решил показать set
        Set<String> set = Arrays.stream(arrStrings).collect(Collectors.toSet());
        System.out.printf("Set size: %s \n", set.size());


        Arrays.stream(arrStrings)
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .forEach((s, count) -> System.out.println(s + ": " + count));


        Stream.of("Сидоров","Петров")
                .peek(System.out::println)
                .flatMap(s -> {
                    return myPhoneBook.get(s).stream();
                })
                .forEach(item -> System.out.println(item.getPhone()));


    }
}
