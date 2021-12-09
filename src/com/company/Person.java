package com.company;

public class Person {
    private String name;
    private String surname;
    private int age;

    public Person(String surname, String name, String age){
        this.surname = surname;
        this.name = name;
        try {
            this.age = Integer.parseInt(age);
        } catch (NumberFormatException ignored) {
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
