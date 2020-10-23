package Employee;

import com.company.Company;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Manager implements Employee
{
    private BigDecimal companyIncome;
    private final BigDecimal fixManagerSalary = new BigDecimal(60000);
    private BigDecimal incomeForCompany = new BigDecimal(Math.random()*25000 + 115000);
    private BigDecimal salaryBonus = new BigDecimal(0.05);
    private BigDecimal monthSalary = fixManagerSalary.add(incomeForCompany.multiply(salaryBonus)).setScale(2, RoundingMode.HALF_UP);

    public Manager(Company company)
    {
        companyIncome = company.getIncome();
    }

    @Override
    public BigDecimal getMonthSalary()
    {
        return monthSalary;
    }
}
