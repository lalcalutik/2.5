package com.example25.model;

import java.util.Objects;

public class Employee {


    private final String firstName;
    private final String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Employee(String firstName, String lastName) {

        this.firstName = firstName;
        this.lastName = lastName;
    }


    @Override
    public String toString() {
        return "_________" + "\n"  + "\n" +
                "Фамилия: " + this.lastName + "\n" + "Имя: " + this.firstName
                + "\n" + "_________";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName)
                && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}