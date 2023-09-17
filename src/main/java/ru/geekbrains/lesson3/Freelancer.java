package ru.geekbrains.lesson3;

import java.util.ArrayList;
import java.util.List;

public class Freelancer extends Employee {

    private Freelancer(String surName, String name, double salary){
        super(surName, name, salary);
    }

    public static Employee getInstance(){
        return new Freelancer(
                surNames[random.nextInt(surNames.length)],
                names[random.nextInt(surNames.length)],
                random.nextInt(600, 1200));
    }

    public static List<Employee> getEmployees(int count){
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < count; i++)
            employees.add(getInstance());
        return employees;
    }

    public Freelancer(){
        super("Default","None",501);
    }

    @Override
    public double calculateSalary() {
        return 20.8 * 8 * salary;
    }

    @Override
    public String toString() {
        return String.format("Freelancer - %s %s; Рабочий; Среднемесячная заработная плата: %.2f (руб.)",
                surName, name, calculateSalary());
    }

}
