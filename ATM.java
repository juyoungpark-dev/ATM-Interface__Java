//entry point

import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {

        //init Scanner:
        Scanner scan = new Scanner(System.in);

        //init Bank:
        Bank theBank = new Bank("TD Bank");

        //add a user, which also creates a savings account:
        User user = theBank.addUser("Kaitlyn", "Park", "1234"); //addUser returns the User object

        //add a chequing account for our user:
        Account account = new Account("Chequing", user, theBank);
        user.addAccount(account);
        theBank.addAccount(account);

    }
}
