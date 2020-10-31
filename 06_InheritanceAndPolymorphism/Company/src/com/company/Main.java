package com.company;

import Employee.Employee;
import Employee.Operator;
import Employee.TopManager;
import Employee.Manager;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args) {

        Company apple = new Company("Apple");
        ArrayList<Employee> list = new ArrayList<Employee>();
        for (int i = 0; i <= 180; i++)
            list.add(new Operator());
        for (int i = 0; i <= 80; i++)
            list.add(new Manager());
        for (int i = 0; i <= 10; i++)
            list.add(new TopManager());
        apple.hireAll(list);
        apple.getTopSalaryStaff(10);
        apple.getLowestSalaryStaff(30);

        apple.fire(200);
        apple.getTopSalaryStaff(10);
        apple.getLowestSalaryStaff(30);

    }
}
