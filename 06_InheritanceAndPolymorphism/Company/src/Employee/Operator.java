package Employee;

import com.company.Company;

import java.math.BigDecimal;

public class Operator implements Employee
{
    Company company;
    BigDecimal companyIncome;
    private final BigDecimal fixEmployeeSalary = new BigDecimal(45000);

    public Operator(){}

    @Override
    public BigDecimal getMonthSalary() {
        return fixEmployeeSalary;
    }

    @Override
    public void setCompany(Company company)
    {
        this.company = company;
        companyIncome = this.company.getIncome();
    }
}
