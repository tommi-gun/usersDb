package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // получить коллекцию польз и вывести на экран столбиком
        // возраст сделать опциональном(возраста может не быть)
        // отсортировать польз по возрасту, по убыванию, без возраста в начало списка
        List<String> list = new LinkedList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(
                "C:\\Users\\79168\\IdeaProjects\\test\\src\\com\\company\\users"))) {

            while (reader.ready()){
                String readString = reader.readLine();
                list.add(readString);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Person>people = getPeople(list);
        people = getSortedPeople(people);
        for (Person person: people
             ) {
            System.out.printf("%s %s %s\n",person.getSurname(),person.getName(),person.getAge() == 0 ? "" : person.getAge());
        }
    }
    //преобразование из прочитанных строк из файла в коллекцию
    public static List<Person> getPeople(List<String> list) {
        List<Person> people = new LinkedList<>();
        for (int i = 0; i < list.size();) {
            if (i + 2 < list.size()){
                people.add(new Person(list.get(i),list.get(i+1),list.get(i+2)));
                i += 3;
            }
            else i++;
        }
        return people;
    }

    //сортировка коллекции
    public static List<Person> getSortedPeople(List<Person>people) {
        int [] ages = new int[people.size()];
        for (int i = 0; i < people.size(); i++) {
            Person person = people.get(i);
            ages[i] = person.getAge();
        }
        selectionSort(ages, 0, ages.length - 1);
        List<Person> personList = new LinkedList<>();
        for (int age : ages) {
            int count = 0;
            for (int i = 0; i < people.size(); i++) {
                Person person = people.get(i);
                if (person.getAge() == age) {
                    count = i;
                    personList.add(person);
                    break;
                }
            }
            people.remove(count);
        }
        return personList;
    }

    // Алгоритм сортировки выбором
    public static void selectionSort(int[] numbers, int low, int high) {
        for (int h = low; h <= high; h++)
            swap(numbers, h, getSmallest(numbers, h, high));
    }


    public static int getSmallest(int[] numbers, int low, int high) {
        int small = low;
        for (int i = low + 1; i <= high; i++)
            if (numbers[i] < numbers[small])
                small = i;
        return small;
    }

    public static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
