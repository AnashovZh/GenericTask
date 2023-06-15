package project.model;

import java.util.ArrayList;

public class DataBase {
    private ArrayList<Person>people=new ArrayList<>();
    private ArrayList<Animal>animals=new ArrayList<>();

    public DataBase() {
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }
}
