package kz.aitu.oop.practice.assignment4.entities;


public class Employee {
    /*
   Some fields of Employee entity
  */
    private int id;
    private String name;
    private String surname;
    private String email ;
    private boolean gender;
    private String occupancy ;
    private int experience;
    private int salary ;

   /*
    First constructor that accepts no-arguments
   */
    public Employee(){

    }
    /*
    Second constructor that accepts all arguments
    */
    public Employee(int id, String name, String surname, String email, boolean gender, String occupancy, int experience, int salary) {
        setId(id);
        setName(name);
        setSurname(surname);
        setEmail(email);
        setGender(gender);
        setOccupancy(occupancy);
        setExperience(experience);
        setSalary(salary);
    }
    /*
        Third constructor that accepts all arguments , except id attribute
        */
    public Employee(String name, String surname, String email , boolean gender , String occupancy , int experience, int salary) {
        setName(name);
        setSurname(surname);
        setEmail(email);
        setGender(gender);
        setOccupancy(occupancy);
        setExperience(experience);
        setSalary(salary);


    }


    /*
        Next I got getters and setters for each field
        */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(String occupancy) {
        this.occupancy = occupancy;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }



    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }



/*
    method toString used for presenting string that will reveal fields of the object
    */

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender= " + (gender ? "Male" : "Female") +
                ", occupancy= " +occupancy + '\''+
                ", salary= " +salary + '\''+
                '}' +  "\n";

    }
    // \n
}