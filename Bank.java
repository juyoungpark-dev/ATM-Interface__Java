import java.util.Random;
import java.util.ArrayList;

public class Bank {
    // member variables:
    private String name;
    private ArrayList<User> users;
    private ArrayList<Account> accounts;

    // Constructor:
    public Bank(String name) {
        this.name = name;
        users = new ArrayList<User>();
        accounts = new ArrayList<Account>();
    }

    // methods:
    public String getNewUserUUID() {
        String uuid;
        int len = 6;
        Random random = new Random();
        boolean unique = true;

        do {

            // generate random uuid:
            uuid = "";
            for (int i = 0; i < len; i++) {
                uuid += ((Integer) random.nextInt(10)).toString(); // random digit [0-9]
            }

            // compare to every user's uuid if it's unique or not
            for (User u : users) {
                if (uuid.equals(u.getUUID())) {
                    unique = false;
                    break;
                }
            }
        } while (!unique);

        return uuid;
    }

    public String getNewAccountUUID() {
        String uuid = "";
        int len = 10;

        Random random = new Random();
        boolean unique = true;
        do {
            // generate random uuid:
            for (int i = 0; i < len; i++) {
                uuid += ((Integer) random.nextInt(10)).toString();
            }

            // compare to other accounts' uuids to check uniqueness:
            for (Account acc : accounts) {
                if (uuid.equals(acc.getUUID())) {
                    unique = false;
                    break;
                }
            }
        } while (!unique);

        return uuid;
    }

    /**
     * 
     * @param anAcct the account to add
     */
    public void addAccount(Account anAcct) {
        this.accounts.add(anAcct);
    }

    /**
     * 
     * @param firstname the user's first name
     * @param lastname  the user's last name
     * @param pin       the user's pin
     * @return the user object
     */
    public User addUser(String firstname, String lastname, String pin) {
        // create a new user object and add it to the list
        User user = new User(firstname, lastname, pin, this);
        this.users.add(user);

        // create a savings account for the user:
        Account newAccount = new Account("Savings", user, this); // create a new acc
        user.addAccount(newAccount); // add the new acc to the user's accounts list
        this.accounts.add(newAccount); // add the new acc to the bank's accounts list

        return user;
    }

    /**
     * 
     * @param userID typed userID
     * @param pin    typed pin for the userID
     * @return       the user if exists, or null
     */
    public User userLogin(String userID, String pin) {

        for (User u : this.users) {
            if(userID.equals(u.getUUID()) && u.validatePin(pin)){ 
                return u;
            }
        }
        // if there's no such user:
        return null;
    }
}
