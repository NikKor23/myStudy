package Employee;

import com.company.Company;

import java.math.BigDecimal;

public class Operator implements Employee
{
    BigDecimal companyIncome;
    private final BigDecimal fixEmployeeSalary = new BigDecimal(45000);

    public Operator(Company company)
    {
        companyIncome = company.getIncome();
    }

    @Override
    public BigDecimal getMonthSalary() {
        return fixEmployeeSalary;
    }
}
