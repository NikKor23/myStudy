package Employee;

import java.math.BigDecimal;

public class Operator implements Employee
{
    private final BigDecimal fixEmployeeSalary = new BigDecimal(45000);

    public void Operator()
    {

    }

    @Override
    public BigDecimal getMonthSalary(BigDecimal income) {
        return fixEmployeeSalary;
    }
}
