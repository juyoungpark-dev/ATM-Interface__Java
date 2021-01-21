import java.util.Date;

public class Transaction {
    private double amount;
    private Date timestamp;
    private String memo;
    private Account inAccount;

    // 2arg-Constructor:
    public Transaction(double amt, Account inAcc) {
        this.amount = amt;
        this.inAccount = inAcc;
        this.memo = "";
        this.timestamp = new Date();
    }

    // 3arg-Constructor:
    public Transaction(double amt, Account inAcc, String memo) {
        // call the default constr first
        this(amt, inAcc);
        // set the memo
        this.memo = memo;
    }

    /**
     * Get the amount of the transaction
     * @return the amount
     */
    public double getAmount() {
        return this.amount;
    }

    /**
     * Get summary line of a transaction - timestamp : amount : memo
     * @return summaryline
     */
    public String getSummaryLine(){
        String summaryLine;

        if(this.amount >= 0){
            summaryLine = String.format("%s : $%.02f : %s", this.timestamp.toString(), this.amount, this.memo);
        }else{
            summaryLine = String.format("%s : $(%.02f) : %s", this.timestamp.toString(), this.amount, this.memo);
        }
        
        return summaryLine;
    }
}
