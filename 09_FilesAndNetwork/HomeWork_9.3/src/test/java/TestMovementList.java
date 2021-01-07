import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Файл test/resources/movementList.csv")
public class TestMovementList {

    private static final double DELTA = 0.01;
    private static final String FILENAME = "src/test/resources/movementList(UTF8).txt";

    @Test
    @DisplayName("Сумма прихода")
    void testSumIncome() {
        assertEquals(460_800.0, new Movements(FILENAME).getIncomeSum(), DELTA);
    }

    @Test
    @DisplayName("Сумма расходов")
    void testSumExpense() {
        assertEquals(466_393.07, new Movements(FILENAME).getExpenseSum(), DELTA);
    }

    private String getCsvFilenamePath() {
        return this.getClass().getResource(FILENAME).getPath();
    }

}