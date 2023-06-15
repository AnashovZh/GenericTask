package project.service.serviceImpl;

import project.enums.Gender;
import project.model.Animal;
import project.service.GenericService;
import project.model.DataBase;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class AnimalServiceImpl implements GenericService <Animal>    {
    private DataBase database;

    public AnimalServiceImpl(DataBase database) {
        this.database = database;
    }

    Scanner scanner = new Scanner(System.in);


    @Override
    public String add(List t) {
        database.getAnimals().addAll(t);
        return "Animals uspeshno dobavlenno";
    }

    @Override
    public Animal getById(Long id) {
        for (Animal a : database.getAnimals()) {
            if (a.getId().equals(id)) {
                System.out.println(a);
            }
        }
        return null;
    }

    @Override
    public List getAll() {

        return database.getAnimals();
    }

    @Override
    public List sortByNameAZza() {
        System.out.println("1-AZ  2-ZA");
        int n = scanner.nextInt();
        if (n == 1) {
            Collections.sort(database.getAnimals(), animalComparatorAZ);
            return database.getAnimals();
        } else if (n==2){
            Collections.sort(database.getAnimals(), animalComparatorAZ.reversed());
            return database.getAnimals();
        }else {
            System.err.println("1 жана 2 баскычын гана басыныз!");
        }return null;
    }

    @Override
    public List filterByGenderM() {
        System.out.println("1 male 2 female");
        int n = scanner.nextInt();
        if (n == 1) {
            for (int i = 0; i < database.getAnimals().size(); i++) {
                if (database.getAnimals().get(i).getGender().equals(Gender.MALE)) {
                    System.out.println(database.getAnimals().get(i));
                }
            }
        } else if (n==2){
            for (Animal a : database.getAnimals()) {
                if (a.getGender().equals(Gender.FEMALE)) {
                    System.out.println(a);
                }
            }
        }else {
            System.err.println("1 же 2 ни гана танданыз!");
        }
        return null;
    }

    @Override
    public List clear() {
        database.getAnimals().clear();
        return database.getAnimals();
    }

    public static Comparator<Animal> animalComparatorAZ = new Comparator<Animal>() {
        @Override
        public int compare(Animal o1, Animal o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };
}
