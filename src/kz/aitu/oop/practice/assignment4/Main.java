package kz.aitu.oop.practice.assignment4;

import kz.aitu.oop.practice.assignment4.data.PostgresDB;
import kz.aitu.oop.practice.assignment4.data.interfaces.IDB;
import kz.aitu.oop.practice.assignment4.repositories.EmployeeRepository;
import kz.aitu.oop.practice.assignment4.repositories.interfaces.IEmployeeRepository;

public class Main {

    public static void main(String[] args) {

        // Here we clarify which DB and Repository to use

        IDB db = new PostgresDB();

        IEmployeeRepository repo = new EmployeeRepository(db);
        MyApplication app = new MyApplication(repo);
        app.start();
    }
}