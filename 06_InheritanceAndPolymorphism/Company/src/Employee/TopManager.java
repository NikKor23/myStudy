package Employee;

import com.company.Company;
import java.math.BigDecimal;

public class TopManager implements Employee{

    private Company company;
    private BigDecimal companyIncome = new BigDecimal(0);
    private final BigDecimal fixTopManagerSalary = new BigDecimal(90000.00);
    private final BigDecimal incomeThreshold = new BigDecimal(10000000.00);
    private BigDecimal salaryBonus = new BigDecimal(1.5);
    private BigDecimal monthSalary = fixTopManagerSalary;

    public TopManager(){}

    @Override
    public BigDecimal getMonthSalary()
    {
        if (companyIncome.compareTo(incomeThreshold) > 0) return monthSalary.multiply(salaryBonus);
        return monthSalary;
    }

    @Override
    public void setCompany(Company company) {
        this.company = company;
        companyIncome = this.company.getIncome();
    }
}
