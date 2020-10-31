package Employee;

import com.company.Company;
import java.math.BigDecimal;

public class TopManager implements Employee{

    private Company company;
    private final BigDecimal fixTopManagerSalary = new BigDecimal(90000.00);
    private final BigDecimal salaryBonus = new BigDecimal(1.5);
    private  final BigDecimal incomeThreshold  = new BigDecimal(10000000.00);
    private BigDecimal monthSalary;

    public TopManager()
    {
        monthSalary = fixTopManagerSalary;
    }

    @Override
    public BigDecimal getMonthSalary()
    {
        if (company.getIncome().compareTo(incomeThreshold) > 0) return monthSalary.multiply(salaryBonus);
        return monthSalary;
    }

    @Override
    public void setCompany(Company company)
    {
        this.company = company;
    }
}
