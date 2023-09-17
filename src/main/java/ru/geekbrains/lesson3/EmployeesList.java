package ru.geekbrains.lesson3;

import java.util.ArrayList;
import java.util.Iterator;

public class EmployeesList extends Employee implements Iterator<Employee>, Iterable {

    public ArrayList<Employee> employees = new ArrayList<>();
    private Integer employeesID = 0;

    public void add(Employee employee){
        employees.add(employee);
    }

    public void addAll(int count){
        int position;
        for (int i = 0; i < count; i++) {
            position = random.nextInt(-1, 2);
            if (position > 0)
                employees.add(Freelancer.getInstance());
            else
                employees.add(Worker.getInstance());
        }
    }

    @Override
    public String toString() {
        String sb = "";
        for (int i = 0; i < employees.size(); i++) {
            sb += employees.get(i) + "\n";
        }
        return sb;
    }

    public int getSize(){
        return employees.size();
    }

    public Employee getEmployee(int i){
        return employees.get(i);
    }

    @Override
    public boolean hasNext() {
        return (this.employeesID < this.employees.size());
    }

    @Override
    public Employee next() {
        return this.employees.get(this.employeesID++);
    }

    @Override
    public Iterator<Employee> iterator() {
        ArrayList<Employee> employee = new ArrayList<>();
        employee.addAll(this.employees);
        Iterator<Employee> iter = employee.iterator();
        return iter;
    }

    @Override
    public void remove() {
        this.employees.remove(this.employeesID);
    }

    public void removeEmployeeBySurName(String remove){
        for (int i = 0; i < employees.size(); i++) {
            if(employees.get(i).getSurName().equals(remove)){
                employees.remove(i);
            }
        }
    }

    protected EmployeesList(String surName, String name, double salary) {
        super(surName, name, salary);
    }

    @Override
    public double calculateSalary() {
        return 0;
    }
}
