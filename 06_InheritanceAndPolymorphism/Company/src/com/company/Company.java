package com.company;

import Employee.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Company
{
    private String name;
    protected BigDecimal income;
    public List<Employee> employees;

    public Company(String name)
    {
        this.name = name;
        this.income =  new BigDecimal((Math.random() * 4500000) + 7000000);
        this.income = getIncome().setScale(2, RoundingMode.HALF_UP);
        System.out.println("Добавлена компания " + this.name +
                ". Месячный доход компании " + this.income);
        employees = new ArrayList<>();
    }

    public BigDecimal getIncome()
    {
        return income;
    }

    public void hire(Employee employee)
    {
        employee.setCompany(Company.this);
        employees.add(employee);
    }

    public void hireAll(List<Employee> list)
    {
        for (int i = 0; i < list.size(); i++) hire(list.get(i));
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
              randomNumber = (int) (Math.random() * (employees.size() - 1)) ;
              employees.remove(randomNumber);
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
            System.out.println("Top salary staff: ");
            employees.sort((o1, o2) -> o2.getMonthSalary().compareTo(o1.getMonthSalary()));
            if (count > employees.size()) count = employees.size();
            BigDecimal p = new BigDecimal(0);
            int j = 0;
            for (int i = 0; i < count; i++) {
                if (!employees.get(j).getMonthSalary().equals(p)) System.out.print(employees.get(j).getMonthSalary() + " ");
                else i--;
                p = employees.get(j).getMonthSalary();
                j++;
                if (j == employees.size()-1) return employees;
            }
            System.out.println();
            return employees;
        }
    }

    public List<Employee> getLowestSalaryStaff(int count)
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
            System.out.println("Lowest salary staff: ");
            if (count > employees.size()) count = employees.size();
            employees.sort(Comparator.comparing(o -> o.getMonthSalary()));
            BigDecimal p = new BigDecimal(0);
            int j = 0;
            for (int i = 0; i < count; i++) {
                if (!employees.get(j).getMonthSalary().equals(p)) System.out.print(employees.get(j).getMonthSalary() + " ");
                else i--;
                p = employees.get(j).getMonthSalary();
                j++;
                if (j == employees.size()-1) return employees;
            }
            System.out.println();
            return employees;
        }
    }
}
