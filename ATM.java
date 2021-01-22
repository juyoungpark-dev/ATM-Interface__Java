//entry point

import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {

        // init Scanner:
        Scanner sc = new Scanner(System.in);

        // init Bank:
        Bank theBank = new Bank("TD Bank");

        // add a user, which also creates a savings account:
        User aUser = theBank.addUser("Kaitlyn", "Park", "1234"); // addUser returns the User object

        // add a chequing account for our user:
        Account account = new Account("Chequing", aUser, theBank);
        aUser.addAccount(account);
        theBank.addAccount(account);

        User curUser;
        boolean exit = false;
        while (!exit) {
            // stay in the login prompt until successful login
            curUser = ATM.mainMenuPrompt(theBank, sc);

            // stay in main menu until user quits
            exit = ATM.printUserMenu(curUser, sc, theBank);
        }

    }

    // static methods of ATM class:
    // (static because there's no data member of ATM class, which means there won't
    // be an ATM instance)

    /**
     * @param bank which bank system to access to
     * @param sc   passed scanner to read user input
     * @return User object
     */
    public static User mainMenuPrompt(Bank bank, Scanner sc) {
        // inits
        String userID;
        String pin;
        User authUser;

        // promt the user for user ID/pin until it's verified
        do {
            System.out.println("Welcome to " + bank.getName());
            System.out.print("Enter user ID: ");
            userID = sc.nextLine();
            System.out.print("Enter pin: ");
            pin = sc.nextLine();

            // try to get the User matching to the given information
            authUser = bank.userLogin(userID, pin);
            if (authUser == null) {
                System.out.println("Incorrect user ID or pin" + "Plase try again.");
            }
        } while (authUser == null);
        return authUser;
    }

    /**
     * @param theUser
     * @param sc
     */
    public static boolean printUserMenu(User theUser, Scanner sc, Bank theBank) {

        // print a summary of user's accounts
        theUser.printAccountsSummary();

        // init
        int choice = -1;

        // user menu
        System.out.printf("Welcome %s, what would you like to do?\n", theUser.getFirstName());
        do {
            System.out.println("  1) View Transactions");
            System.out.println("  2) Withdrawl");
            System.out.println("  3) Deposit");
            System.out.println("  4) Transfer");
            System.out.println("  5) Quit");
            System.out.println();
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            if (choice < 1 || choice > 5) {
                System.out.println("Invalid choice. Please choose 1-5");
            }

        } while (choice < 1 || choice > 5);

        // process the choice
        switch (choice) {
            case 1: // account transaction history
                ATM.showTransactionHistory(theUser, sc);
                break;
            case 2: // withdrawl
                ATM.withdraw(theUser, sc);
                break;
            case 3: // deposit
                ATM.deposit(theUser, sc);
                break;
            case 4: // transfer
                ATM.transfer(theUser, sc);
                break;
            case 5: // quit
                System.out.println("Thanks for using " + theBank.getName() +". Goodbye!");
                return true;
            default:
                break;
        }

        // redisplay this menu unless the user wants to quit
        if (choice != 5) {
            ATM.printUserMenu(theUser, sc, theBank);
        }

        return false;
    }

    /**
     * show transaction history for a particular account
     * 
     * @param theUser the current logged-in user
     * @param sc      Scanner to read user input
     */
    public static void showTransactionHistory(User theUser, Scanner sc) {

        int theAcct;

        // get account whose transaction history to look at
        do {
            System.out.printf("Enter the number (1-%d) of the accounts\n" + " whose transactions you want to see: ",
                    theUser.numAccounts());
            theAcct = sc.nextInt() - 1;
            if (theAcct < 0 || theAcct >= theUser.numAccounts()) {
                System.out.println("Invalid account. Please try again.");
            }
        } while (theAcct < 0 || theAcct >= theUser.numAccounts());

        // print the transaction history
        theUser.printAcctTransactionHistory(theAcct);

    }

    /**
     * Process transferring funds from one account to another
     * 
     * @param theUser the logged-in User object
     * @param sc      the Scanner object used for user input
     */
    public static void transfer(User theUser, Scanner sc) {
        // inits
        int fromAcct;
        int toAcct;
        double amount;
        double acctBal;

        // get the account to transfer from
        do {
            System.out.printf("Enter the number (1-%d) of the account\n" + "to transfer from: ", theUser.numAccounts());
            fromAcct = sc.nextInt() - 1;
            if (fromAcct < 0 || fromAcct >= theUser.numAccounts()) {
                System.out.println("Invalid account. Please try again");
            }
        } while (fromAcct < 0 || fromAcct >= theUser.numAccounts());
        acctBal = theUser.getAcctBalance(fromAcct);

        // get the account to transfer to
        do {
            System.out.printf("Enter the number (1-%d) of the account\n" + "to transfer from: ", theUser.numAccounts());
            toAcct = sc.nextInt() - 1;
            if (toAcct < 0 || toAcct >= theUser.numAccounts()) {
                System.out.println("Invalid account. Please try again");
            }
        } while (toAcct < 0 || toAcct >= theUser.numAccounts());

        // get the amount to transfer
        do {
            System.out.printf("Enter the amount to transfer (max $%.02f): $", acctBal);
            amount = sc.nextDouble();
            if (amount < 0) {
                System.out.println("Amount must be greater than zero");
            } else if (amount > acctBal) {
                System.out.println("Amount must not be greater than balance of " + acctBal);
            }
        } while (amount < 0 || amount > acctBal);

        // finally, do the transfer
        theUser.addAcctTransaction(fromAcct, -1 * amount,
                String.format("Transfer to account %s", theUser.getAccctUUID(toAcct)));
        theUser.addAcctTransaction(toAcct, amount,
                String.format("Transfer from account %s", theUser.getAccctUUID(fromAcct)));
    }

    /**
     * Withdraw a fund from an account
     * 
     * @param theUser the logged-in User object
     * @param sc      the Scanner objecyt user for user input
     */
    public static void withdraw(User theUser, Scanner sc) {
        // inits
        int fromAcct;
        double amount;
        double acctBal;
        String memo;

        // get the account to withdraw from
        do {
            System.out.printf("Enter the number (1-%d) of the account\n" + "to transfer from: ", theUser.numAccounts());
            fromAcct = sc.nextInt() - 1;
            if (fromAcct < 0 || fromAcct >= theUser.numAccounts()) {
                System.out.println("Invalid account. Please try again");
            }
        } while (fromAcct < 0 || fromAcct >= theUser.numAccounts());
        acctBal = theUser.getAcctBalance(fromAcct);

        // get the amount to withdraw
        do {
            System.out.printf("Enter the amount to withdraw (max $%.02f): $", acctBal);
            amount = sc.nextDouble();
            if (amount < 0) {
                System.out.println("Amount must be greater than zero");
            } else if (amount > acctBal) {
                System.out.println("Amount must not be greater than balance of " + acctBal);
            }
        } while (amount < 0 || amount > acctBal);

        // gooble up rest of previous input
        sc.nextLine();

        // get a memo
        System.out.println("Enter a memo: ");
        memo = sc.nextLine();

        // do the withdrawl
        theUser.addAcctTransaction(fromAcct, -1 * amount, memo);

    }

    /**
     * Deposit a fund to an account
     * 
     * @param theUser the logged-in User object
     * @param sc      the Scanner object used for user input
     */
    public static void deposit(User theUser, Scanner sc) {
        // inits
        int toAcct;
        double amount;
        double acctBal;
        String memo;

        // get the account to deposit to
        do {
            System.out.printf("Enter the number (1-%d) of the account\n" + "to transfer from: ", theUser.numAccounts());
            toAcct = sc.nextInt() - 1;
            if (toAcct < 0 || toAcct >= theUser.numAccounts()) {
                System.out.println("Invalid account. Please try again");
            }
        } while (toAcct < 0 || toAcct >= theUser.numAccounts());
        acctBal = theUser.getAcctBalance(toAcct);

        // get the amount to deposit
        do {
            System.out.print("Enter the amount to deposit: $");
            amount = sc.nextDouble();
            if (amount < 0) {
                System.out.println("Amount must be greater than zero");
            }
        } while (amount < 0);

        // gooble up rest of previous input
        sc.nextLine();

        // get a memo
        System.out.println("Enter a memo: ");
        memo = sc.nextLine();

        // do the deposit
        theUser.addAcctTransaction(toAcct, amount, memo);
    }
}
