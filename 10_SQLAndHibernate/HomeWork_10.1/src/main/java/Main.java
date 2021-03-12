import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static final String URL = "jdbc:mysql://localhost:3306/skillbox";
    public static final String USER = "root";
    public static final String PASSWORD = "testtest";

    public static void main(String[] args)
    {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT course_name AS Имя_курса, " +
                    "COUNT(subscription_date)/MONTH(MAX(subscription_date)) AS Покупок_в_месяц " +
                    "FROM Purchaselist GROUP BY course_name;");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("Имя_курса") + "\t" + resultSet.getString("Покупок_в_месяц"));
            }

            resultSet.close();
            statement.close();
            connection.close();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
