package kz.aitu.oop.practice.assignment4.controllers;

import kz.aitu.oop.practice.assignment4.entities.Employee;



public class ProjectController {

    private Employee employee1 = new Employee();
    private Employee employee2 = new Employee();
    private Employee employee3 = new Employee();
    /*
    Is used for calculating the cost of project used for employees too
      */
    public int calculateCost(Employee employee1, Employee employee2, Employee employee3){
        return employee1.getSalary() + employee2.getSalary() + employee3.getSalary();
    }
}