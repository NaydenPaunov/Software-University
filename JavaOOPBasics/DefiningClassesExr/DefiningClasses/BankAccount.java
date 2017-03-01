package DefiningClasses;

/**
 * Created by na4oy on 24.2.2017 г..
 */
public class BankAccount {
    private Integer id;
    private double balance;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit (double amount){
        if(amount < 0){
            throw new IllegalArgumentException("Amount should be non negative");
        }
        this.balance += amount;
    }

    public void withdraw(double amount){
        if(amount > this.balance){
            throw new IllegalStateException("Insufficient balance");
        }
        this.balance  -= amount;
    }

    public String toString(){
        return "ID" + this.id;
    }
}
