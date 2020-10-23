package com.company;

public class Main
{
    public static void main(String[] args) {

        Company apple = new Company("Apple");
        apple.hireAll("operator",180);
        apple.hireAll("manager",80);
        apple.hireAll("topmanager",10);
        apple.getTopSalaryStaff(10);
        apple.getLowestSalaryStaff(30);
        apple.fire(135);
        apple.getTopSalaryStaff(10);
        apple.getLowestSalaryStaff(30);



    }
}
