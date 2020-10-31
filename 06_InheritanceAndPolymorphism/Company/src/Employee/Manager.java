package Employee;

import com.company.Company;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Manager implements Employee
{
    private Company company;
    private final BigDecimal fixManagerSalary = new BigDecimal(60000);
    private final BigDecimal salaryBonus = new BigDecimal(0.05);
    private BigDecimal incomeForCompany;
    private BigDecimal monthSalary;

    public Manager()
    {
        incomeForCompany = new BigDecimal(Math.random()*25000 + 115000);
    }

    @Override
    public BigDecimal getMonthSalary()
    {
        return monthSalary;
    }

    @Override
    public void setCompany(Company company)
    {
        this.company = company;
        monthSalary = fixManagerSalary.add(incomeForCompany.multiply(salaryBonus)).setScale(2, RoundingMode.HALF_UP);
    }
}
