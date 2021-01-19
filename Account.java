import java.util.ArrayList;

public class Account {
    //member variables:
    private String name;
    private String uuid;
    private User holder;
    private ArrayList<Transaction> transactions;
    
    //Consturctor:
    public Account(String name, User holder, Bank theBank)
    {
        this.name = name;
        this.holder = holder;
        this.uuid = theBank.getNewAccountUUID(); 
        //init transactions
        this.transactions = new ArrayList<Transaction>();
        //add to the holder(user)'s accounts list & bank's accounts list
            //each list is a pointer to the same object (they share same data)
        holder.addAccount(this);
        theBank.addAccount(this);

    }

    
    //methods:
}
