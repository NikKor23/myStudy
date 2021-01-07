
public class Main {

    private static final String movementListFile = "src/test/resources/movementList(UTF8).txt";

    public static void main(String[] args) {
        try {
            Movements movements = new Movements(movementListFile);
            System.out.println("Сумма доходов: " + movements.getIncomeSum());
            System.out.println("Сумма расходов: " + movements.getExpenseSum() + "\n");
            movements.printExpenseCompanies();

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
}
