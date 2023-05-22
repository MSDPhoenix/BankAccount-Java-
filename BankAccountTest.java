public record BankAccountTest() {
    public static void main(String[] args){
        BankAccount account1 = new BankAccount();
        account1.deposit(100.23,"checking");
        account1.deposit(7.462345345,"checking");
        account1.deposit(7.462345345,"checcccking");
        account1.withdraw(5.55,"CHECKING");
        account1.deposit(100.23,"savings");
        account1.deposit(7.462345345,"SavingS");
        account1.deposit(7.462345345,"SAVINGSSSS");
        account1.withdraw(5.55,"SAVINGS");
        account1.displayBalance();
        
        BankAccount account2 = new BankAccount();
        account2.deposit(100.23,"checking");
        account2.deposit(7.462345345,"checking");
        account2.deposit(7.462345345,"checcccking");
        account2.withdraw(5.55,"CHECKING");
        account2.deposit(100.23,"savings");
        account2.deposit(7.462345345,"SavingS");
        account2.deposit(7.462345345,"SAVINGSSSS");
        account2.withdraw(5.55,"SAVINGS");
        account2.displayBalance();
    }
}
