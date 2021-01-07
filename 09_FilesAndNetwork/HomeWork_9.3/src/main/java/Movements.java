import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Movements {
    private static double expenseSum;
    private static double incomeSum;
    private static HashMap<String, Double> expenseCompany;
    private static HashMap<String, Double> incomeCompany;

    public Movements(String pathMovementsCsv)
    {
        expenseCompany =  new HashMap<>();
        incomeCompany = new HashMap<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(pathMovementsCsv));

            for (String line : lines) {
                String[] fragments = line.split("\t");
                if (fragments.length == 6) {
                    stringToMovement(fragments[1],fragments[5]);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public double getExpenseSum() {
        return expenseSum;
    }

    public double getIncomeSum() {
        return incomeSum;
    }

    private static void addExpenseCompany (String name, double movement){
        if (!expenseCompany.containsKey(name)) {
            expenseCompany.put(name, movement);
        }
        else {
            double newMovement = expenseCompany.get(name) + movement;
            expenseCompany.put(name, newMovement);
        }
        expenseSum += movement;
    }

    private static void addIncomeCompany(String name, double movement) {
        if (!incomeCompany.containsKey(name)) {
            incomeCompany.put(name, movement);
        }
        else{
            double newMovement = incomeCompany.get(name) + movement;
            incomeCompany.put(name, newMovement);
        }
        incomeSum += movement;
    }

    private void stringToMovement(String company, String movement) {
        String[] subLine = movement.trim().split(",", 3);
        if (subLine.length == 3) {
            double income = Double.parseDouble(subLine[1].replaceAll("[^0-9,]", "").replaceAll(",","."));
            if  (income == 0.0) {
                double expense = Double.parseDouble(subLine[2].replaceAll("[^0-9,]", "").replaceAll(",","."));
                addExpenseCompany(company, expense);
            }
            else addIncomeCompany(company, income);
        }
    }

    public void printExpenseCompanies(){
        System.out.println("Расходы по компаниям: ");
        for(Map.Entry<String, Double> entry : expenseCompany.entrySet()) {
            String key = entry.getKey();
            Double value = entry.getValue();
            System.out.println(key + "\t" + value);
        }
    }
}
