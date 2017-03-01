package DefiningClasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.util.HashMap;

/**
 * Created by na4oy on 24.2.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {

        HashMap<Integer,BankAccount> accounts = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine();
        while (!command.equals("End")){
            String[] commandArgs = command.split("\\s+");
            String commandType = commandArgs[0];

            switch (commandType){
                case "Create" :
                    executeCreatedCommand(accounts,commandArgs[1]);
                    break;
                case "Deposit" :
                    executeDepositCommand(accounts,commandArgs);
                    break;
                case "Withdraw":
                    executeWithdrawCommand(accounts,commandArgs);
                    break;
                case "Print":
                    executePrintCommand(accounts,commandArgs);
                    break;
            }

            command = reader.readLine();
        }
    }

    private static void executePrintCommand(HashMap<Integer, BankAccount> accounts, String[] commandArgs) {
        Integer id = Integer.valueOf(commandArgs[1]);
        if(!accounts.containsKey(id)) {
            System.out.println("Account does not exist");
            return;
        }
        BankAccount account = accounts.get(id);
        System.out.printf("Account %s, balance %.2f%n",account,account.getBalance());
    }

    private static void executeWithdrawCommand(HashMap<Integer, BankAccount> accounts, String[] commandArgs) {
        Integer id = Integer.valueOf(commandArgs[1]);
        Double amount = Double.valueOf(commandArgs[2]);

        if(!accounts.containsKey(id)){
            System.out.println("Account does not exist");
            return;
        }

        try {
            accounts.get(id).withdraw(amount);
        }catch (IllegalStateException ex){
            System.out.println(ex.getMessage());
        }
    }

    private static void executeDepositCommand(HashMap<Integer, BankAccount> accounts, String[] commandArgs) {
        Integer id = Integer.valueOf(commandArgs[1]);
        Double amaunt = Double.valueOf(commandArgs[2]);

        if(!accounts.containsKey(id)){
            System.out.println("Account does not exist");
            return;
        }

        try {
            accounts.get(id).deposit(amaunt);
        }catch (IllegalArgumentException ex ){
            System.out.println(ex.getMessage());
        }
    }

    private static void executeCreatedCommand(HashMap<Integer, BankAccount> accounts, String commandArg) {
        Integer id = Integer.valueOf(commandArg);
        if(accounts.containsKey(id)){
            System.out.println("Account already exists");
        }else {
            BankAccount account = new BankAccount();
            account.setId(id);
            accounts.put(id,account);
        }
    }
}
