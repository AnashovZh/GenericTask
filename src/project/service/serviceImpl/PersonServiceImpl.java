package project.service.serviceImpl;

import project.enums.Gender;
import project.model.DataBase;
import project.model.Person;
import project.service.GenericService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class PersonServiceImpl implements GenericService<Person> {
    private DataBase dataBase;
    Scanner scanner = new Scanner(System.in);

    public PersonServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String add(List t) {
        dataBase.getPeople().addAll(t);
        return "Saved persons !";
    }

    @Override
    public Person getById(Long id) {
        for (Person p : dataBase.getPeople()) {
            if (p.getId().equals(id)) {
                System.out.println(p);
            }
        }
        return null;
    }

    @Override
    public List getAll() {
        return dataBase.getPeople();
    }

    @Override
    public List sortByNameAZza() {
        System.out.println("1->AZ 2->ZA");
        int n = scanner.nextInt();
        if (n == 1) {
            Collections.sort(dataBase.getPeople(), comparatorAZ);
            return dataBase.getPeople();
        } else if (n == 2) {
            Collections.sort(dataBase.getPeople(), comparatorAZ.reversed());
            return dataBase.getPeople();
        } else {
            System.err.println("1 же 2 гана танданыз");
        }
        return null;
    }


    @Override
    public List filterByGenderM() {
        System.out.println("1-Male 2-Female");
        int n = scanner.nextInt();
        if (n == 1) {
            for (Person p : dataBase.getPeople()) {
                if (p.getGender().equals(Gender.MALE)) {
                    System.out.println(p);
                }
            }
        } else if (n == 2) {
            for (Person p : dataBase.getPeople()) {
                if (p.getGender().equals(Gender.FEMALE)) {
                    System.out.println(p);
                }
            }
        }else {
            System.err.println("1 ди же 2 ни гана танданыз! ");
        }
        return null;
    }


    @Override
    public List clear() {
        dataBase.getPeople().clear();
        return dataBase.getPeople();
    }

    public static Comparator comparatorAZ = new Comparator<Person>() {

        @Override
        public int compare(Person o1, Person o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };
}
