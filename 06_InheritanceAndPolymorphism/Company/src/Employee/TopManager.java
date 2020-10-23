package Employee;

import com.company.Company;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TopManager implements Employee{

    private BigDecimal companyIncome;
    private final BigDecimal fixTopManagerSalary = new BigDecimal(90000);
    private final BigDecimal incomeThreshold = new BigDecimal(10000000);
    private BigDecimal salaryBonus = new BigDecimal(1.5);
    private BigDecimal monthSalary;

    public TopManager(Company company)
    {
        companyIncome = company.getIncome();
        if (companyIncome.compareTo(incomeThreshold) > 0)  monthSalary = fixTopManagerSalary.multiply(salaryBonus);
        else monthSalary =  fixTopManagerSalary;
    }

    @Override
    public BigDecimal getMonthSalary()
    {
        return monthSalary;
    }
}
