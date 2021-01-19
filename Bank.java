import java.util.ArrayList;

public class Bank {
    //member variables:
    private String name;
    private ArrayList<User> users;
    private ArrayList<Account> accounts;


    //methods:
    public String getNewUserUUID(){}
    public StringgetNewAccountUUID(){}
    public void addAccount(Account anAcct){
        this.accounts.add(anAcct);
    }

}
