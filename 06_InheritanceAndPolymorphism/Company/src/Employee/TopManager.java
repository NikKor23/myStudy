package Employee;

import com.company.Company;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TopManager implements Employee{

    private final BigDecimal fixTopManagerSalary = new BigDecimal(90000);
    private final BigDecimal incomeThreshold = new BigDecimal(10000000);
    private BigDecimal salaryBonus = new BigDecimal(1.5);
    private BigDecimal monthSalary ;

    public void TopManager()
    {

    }

    @Override
    public BigDecimal getMonthSalary(BigDecimal income)
    {
        if (income.compareTo(incomeThreshold) > 0) {
            monthSalary = fixTopManagerSalary.multiply(salaryBonus).add(fixTopManagerSalary).setScale(0, RoundingMode.HALF_UP);
        }
        else monthSalary = fixTopManagerSalary.setScale(0, RoundingMode.HALF_UP);
        return monthSalary;
    }
}
