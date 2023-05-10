package ru.netology;

public class PersonBuilder {
    private String name;
    private String surname;
    private Integer age;
    private String city;

    public PersonBuilder() {
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст должен быть больше 0.");
        }

        this.age = age;
        return this;
    }

    public PersonBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public Person build() {
        if (name == null) {
            throw new IllegalStateException("Не заполнено имя.");
        }
        if (surname == null) {
            throw new IllegalStateException("Не заполнена фамилия");
        }

        return new Person(name, surname, age, city);
    }
}
