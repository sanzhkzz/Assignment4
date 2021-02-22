package kz.aitu.oop.practice.assignment4.repositories;

import kz.aitu.oop.practice.assignment4.data.interfaces.IDB;
import kz.aitu.oop.practice.assignment4.entities.Employee;
import kz.aitu.oop.practice.assignment4.repositories.interfaces.IEmployeeRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private final IDB db;

    public EmployeeRepository(IDB db) {
        this.db = db;
    }
    /*
      overriding methods of interface
         */
    @Override
    public boolean createEmployee(Employee employee) {

        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO Employee(name,surname,email,gender,occupancy,experience,salary) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
 /*
    some sql prepared statements to deal with database , like insert into table
      */
            st.setString(1, employee.getName());
            st.setString(2, employee.getSurname());

            st.setString(3,employee.getEmail());
            st.setBoolean(4, employee.getGender());
            st.setString(5,employee.getOccupancy());
            st.setInt(6,employee.getExperience());
            st.setInt(7,employee.getSalary());

            boolean executed = st.execute();
            return executed;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }
    /*
       Is used for getting employees fields via their id
         */
    @Override
    public Employee getEmployee(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,surname,email,gender,occupancy,experience,salary FROM employee WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Employee employee = new Employee(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("email"),
                        rs.getBoolean("gender"),
                        rs.getString("occupancy"),
                        rs.getInt("experience") ,
                        rs.getInt("salary"));

                return employee;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

     /*
    Is used for getting arraylist of employees
      */

    @Override
    public List<Employee> getAllEmployees() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,surname,email,gender,occupancy,experience,salary FROM Employee";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Employee> employees = new ArrayList<>();
            while (rs.next()) {
                Employee employee = new Employee(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("email") ,
                        rs.getBoolean("gender"),
                        rs.getString("occupancy"),
                        rs.getInt("experience"),
                        rs.getInt("salary"));

                employees.add(employee);
            }

            return employees;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    /*
getting salary by id
     */
    @Override
    public int getSalaryById(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT salary FROM employee WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int salary = rs.getInt("salary");

                return salary;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return -1;
    }





    /*
   getting occupancy by id
        */
    @Override
    public String getOccupancyById(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT occupancy FROM employee WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String occupancy = rs.getString("occupancy");

                return occupancy;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return "-1";
    }




}