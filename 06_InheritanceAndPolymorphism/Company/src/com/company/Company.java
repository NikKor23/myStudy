package com.company;

import Employee.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;


public class Company
{
    private String name;
    protected BigDecimal income;
    public List<BigDecimal> employees = new ArrayList<>();
    private List<BigDecimal> employeesSorted = new ArrayList<>();



    public Company(String name)
    {
        this.name = name;
        this.income = getIncome().setScale(2, RoundingMode.HALF_UP);
        System.out.println("Добавлена компания " + this.name +
                ". Месячный доход компании " + this.income);
    }

    public BigDecimal getIncome()
    {
        this.income =  new BigDecimal((Math.random() * 4500000) + 7000000);
        return income;
    }

    public void hire(String string)
    {
        Employee employee;
        if (string ==  "operator") {
            employee = new Operator();
        }
        else if (string ==  "topmanager") {
            employee = new TopManager();
        }
        else if (string ==  "manager"){
            employee = new Manager();
        }
        else {
            System.out.println("Вы наняли уборщицу, она работает на добровольной основе");
            return;
        }
        employees.add(employee.getMonthSalary(income));
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

    public List<BigDecimal> getTopSalaryStaff(int count)
    {
        if (count <= 0) {
            System.out.println("Wrong number");
            return null;
        }
        else {
            employeesSorted.addAll(employees);
            System.out.println("Top salary staff: ");
            if (count > employeesSorted.size()) count = employeesSorted.size();
            employeesSorted.sort(new Comparator<BigDecimal>() {                         // Тут происходит сортировка листа
                public int compare(BigDecimal o1, BigDecimal o2) {
                    return o2.compareTo(o1);
                }
            });
            BigDecimal p = new BigDecimal(0);
            for (int i = 0; i < count; i++) {
                if (!employeesSorted.get(i).equals(p)) System.out.println(employeesSorted.get(i));
                else {
                    employeesSorted.remove(i);                                          // Здесь я вывожу список элементов, при этом проверяю,
                    i--;                                                                // если такой элемент я уже выводил, то удаляю его
                }
                p = employeesSorted.get(i);
            }
            return employeesSorted;
        }
    }

    public List<BigDecimal> getLowestSalaryStaff(int count)
    {
        if (count <= 0) {
            System.out.println("Wrong number");
            return null;
        }
        else {                                                                      // Этот метод полностью такой же как и getTopSalaryStaff,
            employeesSorted.addAll(employees);                                      // за исключением компаратора, он сортирует наоборот
            System.out.println("Lowest salary staff: ");
            if (count > employeesSorted.size()) count = employeesSorted.size();
            employeesSorted.sort(new Comparator<BigDecimal>() {
                public int compare(BigDecimal o1, BigDecimal o2) {
                    return o1.compareTo(o2);
                }
            });
            BigDecimal p = new BigDecimal(0);
            for (int i = 0; i < count; i++) {
                if (!employeesSorted.get(i).equals(p)) System.out.println(employeesSorted.get(i));
                else {
                    employeesSorted.remove(i);
                    i--;
                }
                p = employeesSorted.get(i);
            }
            return employeesSorted;
        }
    }


}
