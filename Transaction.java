import java.util.Date;

public class Transaction {
    private double amount;
    private Date timestamp;
    private String memo;
    private Account inAccount;

    //2arg-Constructor:
    public Transaction(double amt, Account inAcc){
        this.amount = amt;
        this.inAccount = inAcc;
        this.memo = "";
        this.timestamp = new Date();
    }
    //3arg-Constructor:
    public Transaction(double amt, Account inAcc, String memo){
        //call the default constr first
        this(amt,inAcc);
        //set the memo
        this.memo = memo;
    }
}
