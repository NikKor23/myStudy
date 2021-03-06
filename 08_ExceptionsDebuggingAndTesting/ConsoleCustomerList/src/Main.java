import java.util.Scanner;

public class Main
{
    private static String addCommand = "add Василий Петров " +
            "vasily.petrov@gmail.com +79215637722";
    private static String commandExamples = "\t" + addCommand + "\n" +
            "\tlist\n\tcount\n\tremove Василий Петров";
    private static String commandError = "Wrong command! Available command examples: \n" +
            commandExamples;
    private static String helpText = "Command examples:\n" + commandExamples;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        CustomerStorage executor = new CustomerStorage();
        for(;;)
        {
            try {
                String command = scanner.nextLine();
                String[] tokens = command.split("\\s+", 2);
                if (tokens.length == 2) {
                        if (tokens[0].equals("add")) {
                            executor.addCustomer(tokens[1]);
                        } else if (tokens[0].equals("remove")) {
                            executor.removeCustomer(tokens[1]);
                        } else System.out.println(commandError);
                } else if (tokens.length == 1) {
                        if (tokens[0].equals("list")) {
                            if (executor.getCount() == 0) throw new MyException("Customer list is empty");
                            executor.listCustomers();
                        } else if (tokens[0].equals("count")) {
                            if (executor.getCount() == 0) throw new MyException("Customer list is empty");
                            System.out.println("There are " + executor.getCount() + " customers");
                        } else if (tokens[0].equals("help")) {
                            System.out.println(helpText);
                        } else System.out.println(commandError);
                } else throw new IllegalArgumentException(commandError);
            } catch (Exception ex) {
                System.out.println(ex.getLocalizedMessage());
            }
        }
    }
}
