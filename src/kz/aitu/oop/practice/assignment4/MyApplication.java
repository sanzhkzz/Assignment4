package kz.aitu.oop.practice.assignment4;

import kz.aitu.oop.practice.assignment4.controllers.EmployeeController;

import kz.aitu.oop.practice.assignment4.controllers.ProjectController;
import kz.aitu.oop.practice.assignment4.entities.Employee;
import kz.aitu.oop.practice.assignment4.repositories.interfaces.IEmployeeRepository;

import java.util.Scanner;

public class MyApplication {
    /*
is used for interacting with user with presenting command
  */
    private final EmployeeController controller;
    private final Scanner scanner;

    public MyApplication(IEmployeeRepository employeeRepository) {
        controller = new EmployeeController(employeeRepository);
        scanner = new Scanner(System.in);
    }

    public void start() {
        /*
Here are some options for user to choose his interaction
  */
        while (true) {
            System.out.println();
            System.out.println("Welcome to the company !");
            System.out.println("Select option:");
            System.out.println("1. Get all employees");
            System.out.println("2. Get employee by id");
            System.out.println("3. Create employee");
            System.out.println("4. Find salary by id");
            System.out.println("5. Find occupancy by id");
            System.out.println("6. Create project menu");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-6): ");
                int option = scanner.nextInt();
                /*
if / else statements and switch
  */
                if (option == 1) {
                    getAllEmployeesMenu();
                } else if (option == 2) {
                    getEmployeeByIdMenu();
                } else if (option == 3) {
                    createEmployeeMenu();
                } else if (option == 4) {
                    getSalaryByIdMenu();
                } else if (option == 5) {
                    getOccupancyByIdMenu();
                } else if (option == 6) {
                    createProjectMenu();
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next(); // to ignore incorrect input
            }

            System.out.println("*************************");

        }
    }
    /*
    Is used for get all employee list
      */
    public void getAllEmployeesMenu() {
        String response = controller.getAllEmployees();
        System.out.println(response);
    }
    /*
  Is used for get all employee by their unique id
      */
    public void getEmployeeByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        Employee employee = controller.getEmployee(id);
        String response = (employee == null ? "Employee was not found!" : employee.toString());
        System.out.println(response);
    }
    /*
   Is used for get creating and filling out object attributes and fields
       */
    public void createEmployeeMenu() {
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter surname");
        String surname = scanner.next();
        System.out.println("Please enter email");
        String email= scanner.next();

        System.out.println("Please enter gender (male/female)");
        String gender = scanner.next();

        System.out.println("Please enter occupancy of employee");
        String occupancy= scanner.next();

        System.out.println("Please enter experience (in years) in IT");
        int experience= scanner.nextInt();

        System.out.println("Please enter salary of employee");
        int salary= scanner.nextInt();


        String response = controller.createEmployee(name, surname, email, gender , occupancy , experience , salary);
        System.out.println(response);
    }
    /*
    Is used to get salary of workers by id using by menu
       */
    public void getSalaryByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        Employee employee = controller.getEmployee(id);
        String response = (employee == null ? "Salary was not found!" : "" + employee.getSalary());
        System.out.println(response);
    }
    /*
   Is used to get occupancy of workers by id using by menu
       */
    public void getOccupancyByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        Employee employee = controller.getEmployee(id);
        String response = (employee == null ? "Occupancy was not found!" : "" + employee.getOccupancy());
        System.out.println(response);

    }
    /*
   Is used for creating project and implementing three members for them
       */
    public void createProjectMenu() {
        ProjectController projectController = new ProjectController();

           /*
           method implementing choosing three employees responsible for project
      */
        System.out.println("Name of the Project");
        String p_name = scanner.next();
        getAllEmployeesMenu();
        System.out.println("1st member (choose id)");
        int id1 = scanner.nextInt();
        System.out.println("2nd member (choose id)");
        int id2 = scanner.nextInt();
        System.out.println("3rd member (choose id)");
        int id3 = scanner.nextInt();

        Employee employee1 = controller.getEmployee(id1);
        Employee employee2 = controller.getEmployee(id2);
        Employee employee3 = controller.getEmployee(id3);
   /*
 sum of their salaries
      */
        int cost = projectController.calculateCost(employee1, employee2, employee3);

        System.out.println("Team: " + employee1.toString() + " " + employee2.toString() + " " + employee3.toString());
        System.out.println("total cost: " + cost);
    }

}