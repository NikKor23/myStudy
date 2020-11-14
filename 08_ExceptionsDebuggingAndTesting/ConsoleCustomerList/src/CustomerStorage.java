import java.util.HashMap;
import java.util.regex.Pattern;

public class CustomerStorage
{
    private HashMap<String, Customer> storage;

    public CustomerStorage()
    {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws MyException {
        String[] components = data.split("\\s+");
        if (components.length != 4) {
            throw new IllegalArgumentException("Wrong customer format! Correct format: " +
                    "Василий Петров vasily.petrov@gmail.com +79215637722");
        }
        if(!Pattern.matches("[a-zA-z0-9.]*[a-zA-z0-9]@[a-zA-Z]+.[a-z]{2,3}",components[2])) {
            throw new IllegalArgumentException("Wrong e-mail address! Correct format: vasily.petrov@gmail.com");
        }
        if(!Pattern.matches("\\+[7-8]\\d{10}",components[3])) {
            throw new IllegalArgumentException("Wrong customer number! Correct format: +71234567890");
        }
        String name = components[0] + " " + components[1];
        if (storage.containsKey(name)) throw new MyException(name + " is already added");
        storage.put(name, new Customer(name, components[3], components[2]));
    }

    public void listCustomers()
    {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) throws MyException {
        if (!storage.containsKey(name)) {
            throw new MyException("There is not" + name);
        }
        storage.remove(name);
    }

    public int getCount()
    {
        return storage.size();
    }
}