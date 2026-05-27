package com.banking;

public class TransactionService {

    private final NotificationService notificationService;
    
    public TransactionService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void processDeposit(BankAccount account, double amount){
        account.deposit(amount);
        notificationService.sendAlert("Deposit of " + amount + " processed.");
    }

    public void processWithdrawal(BankAccount account, double amount){
        account.withdraw(amount);
        notificationService.sendAlert("Withdrawal of " + amount + " processed.");
    }
    
}
