package kz.aitu.oop.practice.assignment4.repositories.interfaces;

import kz.aitu.oop.practice.assignment4.entities.Employee;

import java.util.List;

public interface IEmployeeRepository {
    /*
   Some abstract methods that will be consequently used in EmployeeRepository
  */
    boolean createEmployee(Employee employee);
    Employee getEmployee(int id);
    List<Employee> getAllEmployees();
    int getSalaryById(int id) ;
    String getOccupancyById(int id) ;


}