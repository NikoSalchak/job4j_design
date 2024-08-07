package ru.job4j.ood.srp.sort;

import ru.job4j.ood.srp.model.Employee;

import java.util.Comparator;

public class EmployeeDescBySalary implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return Double.compare(o2.getSalary(), o1.getSalary());
    }
}
