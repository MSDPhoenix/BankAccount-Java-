import java.text.DecimalFormat;
import java.util.Random;

public class BankAccount {
    private double checkingBalance;
    private double savingBalance;
    private String accountNumber;
    // private static int lastAccountNumber=0;
    private static int numberOfAccounts=0;
    private static double totalMoneyInAccounts=0;

    private String generateAccountNumber(){
        Random random = new Random();
        String newAccountNumber = "";
        for(int i = 0; i<10;i++){
            newAccountNumber += ""+ random.nextInt(10);
        }
        return newAccountNumber;
    }

    public BankAccount(){
        this.checkingBalance = 0;
        this.savingBalance = 0;
        this.accountNumber = generateAccountNumber();
        numberOfAccounts++;
        // lastAccountNumber++;
        System.out.printf("\nCreated account %s\n",this.accountNumber);

    }
    
    private String formatAmount(double amount){
        DecimalFormat df = new DecimalFormat("#.00");
        String amountFormatted = df.format(amount);
        return amountFormatted;
    }

    public String getCheckingBalance(){
        return formatAmount(this.checkingBalance);
    }

    public String getSavingBalance(){
        return formatAmount(this.savingBalance);
    }

    public void deposit(double amount, String account){
        String amountFormatted;
        account = account.substring(0,1).toUpperCase()+account.substring(1).toLowerCase();
        if(account.equals("Savings")){
            this.savingBalance += amount;
            totalMoneyInAccounts += amount;
            amountFormatted = formatAmount(this.savingBalance);
            System.out.printf("\nDeposited %s to %s %s.\n",formatAmount(amount),account,this.accountNumber);
            System.out.printf("%s balance = %s.\n",account,amountFormatted);
            System.out.println(formatAmount(totalMoneyInAccounts));
        } else if(account.equals("Checking")) {
            this.checkingBalance += amount;
            totalMoneyInAccounts += amount;
            amountFormatted = formatAmount(this.checkingBalance);
            System.out.printf("\nDeposited %s to %s %s.\n",formatAmount(amount),account,this.accountNumber);
            System.out.printf("%s balance = %s.\n",account,amountFormatted);
            System.out.println(formatAmount(totalMoneyInAccounts));
        } else {
            System.out.println("\nAccount not recognized "+account);
        }
    }

    public void withdraw(double amount, String account){
        String amountFormatted;
        account = account.substring(0,1).toUpperCase() + account.substring(1).toLowerCase();
        if(!account.equals("Savings") && !account.equals("Checking")){
            System.out.println("\nAccount not recognize: "+account);
        } else if(account.equals("Savings") && this.savingBalance >= amount){
            this.savingBalance -= amount;
            totalMoneyInAccounts -= amount;
            amountFormatted = formatAmount(amount);
            System.out.printf("\nWithdrew %s from %s %s.\n",amountFormatted,account,this.accountNumber);
            System.out.printf("%s balance = %s.\n",account,formatAmount(this.savingBalance));
            System.out.println(formatAmount(totalMoneyInAccounts));
        } else if(account.equals("Checking") && this.checkingBalance >= amount){
            this.checkingBalance -= amount;
            totalMoneyInAccounts -= amount;
            amountFormatted = formatAmount(amount);
            System.out.printf("\nWithdrew %s from %s %s.\n",amountFormatted,account,this.accountNumber);
            System.out.printf("%s balance = %s.\n",account,formatAmount(this.checkingBalance));
            System.out.println(formatAmount(totalMoneyInAccounts));
        } else {
            System.out.println("Insufficient funds");
        }
        System.out.println("");
    }
    public void displayBalance(){
        System.out.printf("\nSavings %s balance = %s",this.accountNumber,formatAmount(this.savingBalance));
        System.out.printf("\nChecking %s balance = %s",this.accountNumber,formatAmount(this.checkingBalance));
        System.out.println("\n"+formatAmount(totalMoneyInAccounts)+"\n");
    }
}

