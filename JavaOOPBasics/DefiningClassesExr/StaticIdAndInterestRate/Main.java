package StaticIdAndInterestRate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by na4oy on 24.2.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {

        HashMap<Integer, BankAccount> accounts = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine();
        while (!command.equals("End")){
            String[] commandArgs = command.split("\\s+");
            String commandType = commandArgs[0];

            switch (commandType){
                case "Create" :
                   BankAccount account = new BankAccount();
                   accounts.put(account.getId(),account);
                    System.out.printf("Account %s created%n",account);
                    break;
                case "Deposit" :
                    executeDepositCommand(accounts,commandArgs);
                    break;
                case "SetInterest":
                    BankAccount.setInterestRate(Double.valueOf(commandArgs[1]));
                    break;
                case "GetInterest":
                    executeGetInterestCommand(accounts,commandArgs);
                    break;
                case "Print":

                    break;
            }

            command = reader.readLine();
        }
    }

    private static void executeGetInterestCommand(HashMap<Integer,BankAccount> accounts , String[] commandArgs){
        Integer id = Integer.valueOf(commandArgs[1]);
        if(!accounts.containsKey(id)) {
            System.out.println("Account does not exist");
        }else {
            double amount = Double.valueOf(commandArgs[2]);
            Integer years = Integer.valueOf(commandArgs[2]);
            BankAccount account = accounts.get(id);
            System.out.printf("%.2f%n",account.getInterestRate(years));
        }
    }

    private static void executeDepositCommand(HashMap<Integer, BankAccount> accounts, String[] commandArgs) {
        Integer id = Integer.valueOf(commandArgs[1]);
        if(!accounts.containsKey(id)){
            System.out.println("Account does not exist");
            return;
        }
        double amount = Integer.valueOf(commandArgs[2]);
        BankAccount account = accounts.get(id);
        accounts.get(id).deposit(amount);
        System.out.printf("Deposited %.0f to %s%n",amount,account);
    }


    /**
     * Created by na4oy on 24.2.2017 г..
     */
    public static class BankAccount {
        private static final Double DEFAULT_INTEREST_RATE = 0.02;

        private static  int accountsCount ;
        private Integer id ;
        private static double currentInterestRate;
        private double balace ;

        public BankAccount(){
            this.id = ++accountsCount;
            currentInterestRate = DEFAULT_INTEREST_RATE;

        }

        public static void setInterestRate(double InterestRate) {
            currentInterestRate = InterestRate;
        }

        public double getInterestRate(Integer years){
            return  this.balace * currentInterestRate* years;
        }

        public void deposit (double amount){
            this.balace += amount;
        }

        public int getId(){
            return this.id ;
        }

        public String toString(){
            return "ID" + this.id;
        }
    }
}
