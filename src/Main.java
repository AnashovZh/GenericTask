import project.enums.Gender;
import project.model.Animal;
import project.model.DataBase;
import project.model.Person;
import project.service.serviceImpl.AnimalServiceImpl;
import project.service.serviceImpl.PersonServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>(List.of(
                new Animal(1L, "Cow", 12, Gender.MALE),
                new Animal(2L, "Tom", 1, Gender.FEMALE),
                new Animal(4L, "Horse", 2, Gender.MALE),
                new Animal(3L, "Mouse", 10, Gender.FEMALE),
                new Animal(6L, "Kit", 120, Gender.MALE),
                new Animal(8L, "At", 3, Gender.MALE),
                new Animal(10L, "Zebra", 11, Gender.MALE),
                new Animal(5L, "Piton", 20, Gender.FEMALE)));
        ArrayList<Person> people = new ArrayList<>(List.of(
                new Person(1L, "Baktulan", 23, Gender.MALE),
                new Person(2L, "Akylai", 20, Gender.FEMALE),
                new Person(3L, "Erjigit", 18, Gender.MALE),
                new Person(4L, "Manas ake", 27, Gender.MALE),
                new Person(5L, "Aizada", 20, Gender.FEMALE),
                new Person(6L, "Daniel", 19, Gender.MALE),
                new Person(7L, "Abubakir", 26, Gender.MALE),
                new Person(8L, "Kanymgul", 23, Gender.FEMALE)));
        DataBase dataBase = new DataBase();
        AnimalServiceImpl animalService = new AnimalServiceImpl(dataBase);
        PersonServiceImpl personService = new PersonServiceImpl(dataBase);
        Scanner scanner = new Scanner(System.in);
        System.out.println("1->Add animal :\n" +
                "2->Get by id animal:\n" +
                "3->Get all animals:\n" +
                "4->Sort by name animals AZza\n" +
                "5->Filter by gender male:\n" +
                "6->Clear by animals:\n" +
                "7->Add persons: \n" +
                "8->Get by id person:\b" +
                "9->Get all persons:\n" +
                "10->Sort by name AZ-ZA:\n" +
                "11->Filter by gender :\n" +
                "12->Clear by persons:\n");
        while (true) {
            int number = scanner.nextInt();
            System.out.println("1->Add animal :\n" +
                    "2->Get by id animal:\n" +
                    "3->Get all animals:\n" +
                    "4->Sort by name animals AZza\n" +
                    "5->Filter by gender male:\n" +
                    "6->Clear by animals:\n" +
                    "7->Add persons: \n" +
                    "8->Get by id person:\n" +
                    "9->Get all persons:\n" +
                    "10->Sort by name AZ-ZA:\n" +
                    "11->Filter by gender :\n" +
                    "12->Clear by persons:\n");
            switch (number) {
                case 1:
                    System.out.println("Add animal :");
                    System.out.println(animalService.add(animals));
                    break;
                case 2:
                    System.out.println("Get by id animal:");
                    System.out.println(animalService.getById(1L));
                    break;
                case 3:
                    System.out.println("Get all animals:");
                    System.out.println(animalService.getAll());
                    break;
                case 4:
                    System.out.println("Sort by name animals AZza");
                    System.out.println(animalService.sortByNameAZza());
                    break;
                case 5:
                    System.out.println("Filter by gender animals: ");
                    System.out.println(animalService.filterByGenderM());
                    break;
                case 6:
                    System.out.println("Clear by animals:");
                    System.out.println(animalService.clear());
                    break;
                case 7:
                    System.out.println("Add person:");
                    System.out.println(personService.add(people));
                    break;
                case 8:
                    System.out.println("Get by id person:");
                    System.out.println(personService.getById(5L));
                    break;
                case 9:
                    System.out.println("Get all persons :");
                    System.out.println(personService.getAll());
                    break;
                case 10:
                    System.out.println("Sort by name AZ-ZA");
                    System.out.println(personService.sortByNameAZza());
                    break;
                case 11:
                    System.out.println("Filter by gender persons:");
                    System.out.println(personService.filterByGenderM());
                    break;
                case 12:
                    System.out.println("Clear persons:");
                    System.out.println(personService.clear());
                    break;
                default:
                    System.err.println("1-12 sandardy gana tandanyz");

            }
        }
    }
}