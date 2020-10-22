package com.company;

import Employee.*;

import java.util.ArrayList;
import java.util.TreeMap;

public class Main
{
    public static void main(String[] args) {

        Company apple = new Company("Apple");
        apple.hireAll("operator",180);
        apple.hireAll("manager",80);
        apple.hireAll("topmanager",10);
        apple.getTopSalaryStaff(15);
        apple.getLowestSalaryStaff(15);
        apple.fire(200);
        apple.getTopSalaryStaff(15);
        apple.getLowestSalaryStaff(15);









    }
}
