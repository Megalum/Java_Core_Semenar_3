package ru.geekbrains.lesson3;

import java.util.Collections;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        List<Employee> employeesWorker = Worker.getEmployees(5);
        List<Employee> employeesFreelancer = Freelancer.getEmployees(5);

        for (Employee employee: employeesWorker) {
            System.out.println(employee);
        }
        System.out.println();
        for (Employee employee: employeesFreelancer) {
            System.out.println(employee);
        }

        Collections.sort(employeesWorker, new EmployeeNameComparator());
        Collections.sort(employeesFreelancer);
        System.out.println();

        for (Employee employee: employeesWorker) {
            System.out.println(employee);
        }
        System.out.println();
        for (Employee employee: employeesFreelancer) {
            System.out.println(employee);
        }
        System.out.println();

        //////////////////////////////////////////////////////////////////////////////

        System.out.println();
        EmployeesList employees = new EmployeesList("Default","None",501);
        employees.add(Freelancer.getInstance());
        employees.add(Worker.getInstance());
        employees.addAll(20);
        System.out.println(employees);
        System.out.println();

        for (int i = 0; i < employees.getSize(); i++) {
            employees.removeEmployeeBySurName("Лыткин");
        }
        System.out.println(employees);
        
    }

}
