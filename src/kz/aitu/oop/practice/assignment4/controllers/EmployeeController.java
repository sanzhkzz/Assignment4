package kz.aitu.oop.practice.assignment4.controllers;

import kz.aitu.oop.practice.assignment4.entities.Employee;
import kz.aitu.oop.practice.assignment4.repositories.interfaces.IEmployeeRepository;

import java.util.List;

public class EmployeeController {
    /*
Controller is used for implementing repo with methods of interface , here you can see some of them
 */
    private final IEmployeeRepository repo;
    private Employee employee1 = new Employee();
    private Employee employee2 = new Employee();
    private Employee employee3 = new Employee();
   /*
three objects of employees are used to implement for one of the methods
 */

    public EmployeeController(IEmployeeRepository repo) {
        this.repo = repo;
    }

    public String createEmployee(String name, String surname, String email , String gender ,String occupancy,int experience , int salary) {
        boolean male = (gender.toLowerCase().equals("male"));
        Employee employee = new Employee(name, surname,email , male ,  occupancy ,experience ,salary );
        boolean created = repo.createEmployee(employee);

        return (created ? "Employee was created!" : "Employee creation was failed!");
    }

    public Employee getEmployee(int id) {
       Employee employee = repo.getEmployee(id);
       return  employee;
    }
    /*
 This used for getting all employees of our DB , with implementing array list we are capable to do that
  */
    public String getAllEmployees() {
        List<Employee> employees = repo.getAllEmployees();
        return employees.toString();
    }
    /*
Is used for searching salary of employee by id
  */

    public String getSalary(int id) {

        int salary = repo.getSalaryById(id);
        return (salary == -1 ? "Salary by id was not found!" : String.valueOf(salary));
    }
    /*
    Is used for searching occupancy of employee by id
      */
    public String getOccupancyById(int id) {
        String occupancy = String.valueOf(repo.getSalaryById(id));
        return (occupancy == "-1" ? "occupancy was not found!" : String.valueOf(occupancy));
    }
    /*
    Is used for gathering salaries of three employees of one project
      */
    public int getAllSalaries(Employee employee1, Employee employee2, Employee employee3) {
       return employee1.getSalary() + employee2.getSalary() + employee3.getSalary();
    }

}