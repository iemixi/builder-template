package ru.netology;


public class App {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setCity("Сидней")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();
        System.out.println("У " + mom + " есть сын, " + son);

        System.out.println("Указан возраст: (hasAge): " + new PersonBuilder()
                .setName("name")
                .setSurname("surname")
                .build()
                .hasAge());

        Person personWithAge = new PersonBuilder()
                .setName("name")
                .setSurname("surname")
                .setAge(12)
                .build();
        System.out.println("Указан возраст: (hasAge): " + personWithAge.hasAge());
        System.out.println("Количество лет до дня рождения: " + personWithAge.getAge());
        personWithAge.happyBirthday();
        System.out.println("Количество лет после дня рождения: " + personWithAge.getAge());

        System.out.println("До добавления города: (hasAddress): " + personWithAge.hasAddress());
        personWithAge.setAddress("Moscow");
        System.out.println("После добавления города: (hasAddress): " + personWithAge.hasAddress());


        try {
            // Не хватает имени
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Не хватает фамилии
            new PersonBuilder().setName("Name").build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
