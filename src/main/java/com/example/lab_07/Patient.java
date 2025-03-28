package com.example.lab_07;

public class Patient {

    // Pola prywatne
    private String firstName;
    private String lastName;
    private int age;
    private int id;

    // Konstruktor
    public Patient(String firstName, String lastName, int age, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.id = id;
    }

    // Gettery
    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getId() {
        return id;
    }

    // Settery

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //Metoda "toString"
    @Override
    public String toString() {
        return "{" +
                "imie='" + firstName + '\'' +
                ", nazwisko='" + lastName + '\'' +
                ", wiek=" + age +
                '}';
    }

}

