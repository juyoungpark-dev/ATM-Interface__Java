import java.util.ArrayList;

public class Account {
    // member variables:
    private String name;
    private String uuid;
    private User holder;
    private ArrayList<Transaction> transactions;

    // Consturctor:
    public Account(String name, User holder, Bank theBank) {
        this.name = name;
        this.holder = holder;
        this.uuid = theBank.getNewAccountUUID();
        // init transactions
        this.transactions = new ArrayList<Transaction>();
    }

    // methods:
    public String getUUID() {
        return this.uuid;
    }

    public double getBalance() {
        double balance = 0.0;
        for (Transaction t : this.transactions) {
            balance += t.getAmount();
        }
        return balance;
    }

    public String getSummaryLine() {
        // get the account's balance
        double balance = this.getBalance();
        String summaryLine;
        // format the summary line, depending on the whether the balance is negative
        if (balance >= 0) {
            summaryLine = String.format("%s : $%.02f : %s", this.uuid, balance, this.name);
        } else {
            summaryLine = String.format("%s : $(%.02f) : %s", this.uuid, balance, this.name);
        }
        return summaryLine;
    }

    /**
     * Print the transaction history of an account
     */
    public void printTransHistory() {
        System.out.printf("\nTransaction history for account %s\n", this.uuid);
        if(this.transactions.size() > 0)
        {
            for (int i = this.transactions.size() - 1; i >= 0; i--) {
                System.out.printf(this.transactions.get(i).getSummaryLine());
            }
        }else{
            System.out.println(" >> Sorry, there isn't any transation yet.");
        }
        System.out.println();
    }

    /**
     * Add a transaction to the account
     * @param amt
     * @param memo
     */
    public void addTransaction(double amt, String memo){
        //create new transation object and add it to our list
        Transaction transaction = new Transaction(amt, this, memo);
        this.transactions.add(transaction);

    }
}
