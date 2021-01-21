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

    public String getFirstName() {
        return this.firstName;
    }

    // add an account to the accounts list of a user.
    public void addAccount(Account anAcct) {
        this.accounts.add(anAcct);
    }

    public String getUUID() {
        return this.uuid;
    }

    /**
     * 
     * @param pin the pin to check
     * @return if the pin is matching or not
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

    // print all the accounts and its balance of a user
    public void printAccountsSummary() {
        System.out.printf("\n%s's accounts summary", this.firstName);
        System.out.println();
        for (int a = 0; a < this.accounts.size(); a++) {
            System.out.printf("  %d) %s\n", a + 1, this.accounts.get(a).getSummaryLine());
        }
    }

    /**
     * Get the number of accounts of the user
     * 
     * @return the number of accounts
     */
    public int numAccounts() {
        return this.accounts.size();
    }

    /**
     * Print the chosen account's transaction history
     * 
     * @param acctIdx the chosen account's index
     */
    public void printAcctTransactionHistory(int acctIdx) {
        this.accounts.get(acctIdx).printTransHistory();
    }

    /**
     * 
     * @param fromAcct
     * @return
     */
    public double getAcctBalance(int fromAcct) {
        return this.accounts.get(fromAcct).getBalance();
    }

    /**
     * Get the UUID of a particular account of the user
     * @param acctIdx the index of the account to use
     * @return the uuid of the account
     */
    public String getAccctUUID(int acctIdx) {
        return this.accounts.get(acctIdx).getUUID();
    }

    /**
     * Add a transaction to a particular account of the user
     * @param acctIdx  account to add the transaction
     * @param amt      
     * @param memo
     */
    public void addAcctTransaction(int acctIdx, double amt, String memo){
        this.accounts.get(acctIdx).addTransaction(amt, memo);
    }
}