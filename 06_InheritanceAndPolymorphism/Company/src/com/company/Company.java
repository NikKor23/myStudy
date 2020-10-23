package com.company;

import Employee.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;


public class Company
{
    private String name;
    protected BigDecimal income;
    public List<Employee> employees = new ArrayList<>();
    private List<Employee> employeesSorted = new ArrayList<>();



    public Company(String name)
    {
        this.name = name;
        this.income =  new BigDecimal((Math.random() * 4500000) + 7000000);
        this.income = getIncome().setScale(2, RoundingMode.HALF_UP);
        System.out.println("Добавлена компания " + this.name +
                ". Месячный доход компании " + this.income);
    }

    public BigDecimal getIncome()
    {
        return income;
    }

    public void hire(String string)
    {
        Employee employee;
        if (string ==  "operator") {
            employee = new Operator(Company.this);
        }
        else if (string ==  "topmanager") {
            employee = new TopManager(Company.this);
        }
        else if (string ==  "manager"){
            employee = new Manager(Company.this);
        }
        else {
            System.out.println("You hired a cleaning lad. She work for free");
            return;
        }
        employees.add(employee);
    }

    public void hireAll(String string, int count)
    {
        for (int i = 1; i <= count; i++)
        {
            hire(string);
        }
        System.out.println("You hire " + count + " " + string + "s. ");
    }

    public void fire(int count)
    {
        if (count > employees.size()) count = employees.size();
        int randomNumber;
        if (count <= 0)
        {
            System.out.println("Wrong number");
            return;
        }
        else
        {
          for (int i = 0; i < count; i++)
          {
              randomNumber = (int) Math.random() * (employees.size() - 1) ;
              employees.remove(randomNumber);
              employeesSorted.clear();
          }
        }
        System.out.println("You hired " + count + " employees");
    }

    public List<Employee> getTopSalaryStaff(int count)
    {
        if (count <= 0) {
            System.out.println("Wrong number");
            return null;
        }
        else {
            if (employees.size() == 0)
            {
                System.out.println("No employees");
                return null;
            }
            employeesSorted.addAll(employees);
            System.out.println("Top salary staff: ");
            if (count > employeesSorted.size()) count = employeesSorted.size();
            employeesSorted.sort(new Comparator<Employee>() {                         // Тут происходит сортировка листа
                public int compare(Employee o1, Employee o2) {
                    return o2.getMonthSalary().compareTo(o1.getMonthSalary());
                }
            });
            BigDecimal p = new BigDecimal(0);
            for (int i = 0; i < count; i++) {
                if (!employeesSorted.get(i).getMonthSalary().equals(p)) System.out.print(employeesSorted.get(i).getMonthSalary() + " ");
                else {
                    employeesSorted.remove(i);                                          // Здесь я вывожу список элементов, при этом проверяю,
                    i--;                                                                // если такой элемент я уже выводил, то удаляю его
                }
                p = employeesSorted.get(i).getMonthSalary();
            }
            System.out.println();
            return employeesSorted;
        }
    }

    public List<Employee> getLowestSalaryStaff(int count)
    {
        if (count <= 0) {
            System.out.println("Wrong number");
            return null;
        }
        else {                                                                      // Этот метод полностью такой же как и getTopSalaryStaff,
            if (employees.size() == 0)                                              // за исключением компаратора, он сортирует наоборот
            {
                System.out.println("No employees");
                return null;
            }
            employeesSorted.addAll(employees);
            System.out.println("Lowest salary staff: ");
            if (count > employeesSorted.size()) count = employeesSorted.size();
            employeesSorted.sort(new Comparator<Employee>() {
                public int compare(Employee o1, Employee o2) {
                    return o1.getMonthSalary().compareTo(o2.getMonthSalary());
                }
            });
            BigDecimal p = new BigDecimal(0);
            for (int i = 0; i < count; i++) {
                if (!employeesSorted.get(i).getMonthSalary().equals(p)) System.out.print(employeesSorted.get(i).getMonthSalary() + " ");
                else {
                    employeesSorted.remove(i);
                    i--;
                }
                p = employeesSorted.get(i).getMonthSalary();
            }

            System.out.println();
            return employeesSorted;
        }
    }

    public void empList()
    {
        for (int i = 0; i < employees.size(); i++)
        {
            System.out.print(employees.get(i).getMonthSalary()+ " ");
        }
    }


}
