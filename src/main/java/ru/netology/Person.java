package ru.netology;

//Также надо создать класс PersonBuilder для конструирования объектов класса Person.
//Объекту этого класса (далее - билдер) можно выставлять любые данные для будущего объекта класса
// Person через методы (например, setName(String name)). И в этом объекте будет метод Person build(),
// возвращающий объект класса Person с указанными билдеру данными. В случае, если мы билдеру не указали достаточное
// количество данных (например, не указали фамилию), то метод build() должен выкинуть IllegalStateException
// с осмысленным сообщением. Если же мы передали неподходящие данные билдеру (например,
// некорректный возрст builder.setAge(-100)), то именно этот метод должен выкинуть IllegalArgumentException с осмысленным сообщением.
// Каждый метод добавления данных в билдер должен возвращать самого себя чтобы можно было сделать, например, вот так:

import java.util.Objects;

public class Person {
    private final String name;
    private final String surname;
    private Integer age;
    private String address;

    public Person(String name, String surname, Integer age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        age += 1;
    }

    public boolean hasAge() {
        return age != null;
    }

    public boolean hasAddress() {
        return address != null;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(this.surname)
                .setAge(this.age - 18)
                .setCity(this.address);
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", city='" + address + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }
}
