import java.util.ArrayList;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {
    // member variables:
    private String firstName;
    private String lastName;
    private String uuid;
    private byte pinHash[];
    private ArrayList<Account> accounts;

    // constructor:
    public User(String fname, String lname, String pin, Bank theBank) {

        this.firstName = fname;
        this.lastName = lname;

        // hashing the pin using MD5 algorithm
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            this.pinHash = md.digest(pin.getBytes());
        }
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        // get a uuid(unique universal ID) for the user
        this.uuid = theBank.getNewUserUUID(); // method of Bank class

        // creat an empty list of accounts
        this.accounts = new ArrayList<Account>();

        // print log message
        System.out.println("New user " + lastName + ", " + firstName + " with ID " + uuid + " created.");
    }

    // methods:
    // add an account to the accounts list of a user.
    public void addAccount(Account anAcct) {
        this.accounts.add(anAcct);
    }

    public String getUUID() {
        return this.uuid;
    }

    /**
     * 
     * @param pin   the pin to check
     * @return      if the pin is matching or not
     */
    public boolean validatePin(String pin) {

        boolean isValidated = false;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            isValidated = MessageDigest.isEqual(md.digest(pin.getBytes()), this.pinHash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        return isValidated;
    }
}