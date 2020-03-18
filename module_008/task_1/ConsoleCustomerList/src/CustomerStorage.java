import java.util.HashMap;
import java.util.regex.Pattern;

public class CustomerStorage
{
    private HashMap<String, Customer> storage;

    public CustomerStorage()
    {
        storage = new HashMap<>();
    }

    public void addCustomer(String data)
    {
        String[] components = data.split("\\s+");
        if (components.length != 4) {
            throw new InvalidEnteredCommandException("Invalid parameters. Type <help> to see available commands " +
                    "and parameters.");
        }
        String name = components[0] + " " + components[1];
        if (!Pattern.compile(".+[@].+$").matcher(components[2]).matches()) {
            throw new InvalidEmailException("Invalid email. Try again.");
        }
        if (!Pattern.compile("[+][0-9]+$").matcher(components[3]).matches()) {
            throw new InvalidPhoneNumberException("Invalid phone number format. Type <help> to see available commands" +
                    " and parameters." );
        }
        storage.put(name, new Customer(name, components[3], components[2]));
    }

    public void listCustomers()
    {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) throws InvalidCustomerNameException
    {
        if (name.split("\\s+").length != 2) {
            throw new InvalidCustomerNameException("Invalid name. Type <help> to see available commands and parameters.");
        }
        storage.remove(name);
    }

    public int getCount()
    {
        return storage.size();
    }
}

class InvalidEnteredCommandException extends RuntimeException {
    public InvalidEnteredCommandException(String message) {
        super(message);
    }
}

class InvalidPhoneNumberException extends RuntimeException {
    public InvalidPhoneNumberException(String message) {
        super(message);
    }
}

class InvalidEmailException extends RuntimeException {
    public InvalidEmailException(String message) {
        super(message);
    }
}

class InvalidCustomerNameException extends RuntimeException {
    public InvalidCustomerNameException(String message) {
        super(message);
    }
}