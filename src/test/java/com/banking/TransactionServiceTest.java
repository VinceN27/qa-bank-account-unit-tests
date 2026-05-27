package com.banking;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("TransactionService Tests")
class TransactionServiceTest {

    @Mock
    NotificationService notificationService;

    @InjectMocks
    TransactionService transactionService;

    // processDeposit() tests
    @Test
    @DisplayName("processDeposit increases account balance")
    void processDeposit_validAmount_increasesBalance() {
        // Arrange
        BankAccount account = new BankAccount(100.0);
        // Act
        transactionService.processDeposit(account, 50.0);
        // Assert
        assertEquals(150.0, account.getBalance());
    }

    @Test
    @DisplayName("processDeposit sends notification alert")
    void processDeposit_sendsNotification() {
        // Arrange
        BankAccount account = new BankAccount(100.0);
        // Act
        transactionService.processDeposit(account, 50.0);
        // Assert
        verify(notificationService).sendAlert("Deposit of 50.0 processed.");
    }

    // processWithdrawal() tests
    @Test
    @DisplayName("processWithdrawal decreases account balance")
    void processWithdrawal_validAmount_decreasesBalance() {
        // Arrange
        BankAccount account = new BankAccount(100.0);
        // Act
        transactionService.processWithdrawal(account, 30.0);
        // Assert
        assertEquals(70.0, account.getBalance());
    }

    @Test
    @DisplayName("processWithdrawal sends notification alert")
    void processWithdrawal_sendsNotification() {
        // Arrange
        BankAccount account = new BankAccount(100.0);
        // Act
        transactionService.processWithdrawal(account, 30.0);
        // Assert
        verify(notificationService).sendAlert("Withdrawal of 30.0 processed.");
    }

    @Test
    @DisplayName("processWithdrawal insufficient funds does not send notification")
    void processWithdrawal_insufficientFunds_noNotificationSent() {
        // Arrange
        BankAccount account = new BankAccount(100.0);
        // Act
        assertThrows(IllegalStateException.class,
            () -> transactionService.processWithdrawal(account, 500.0));
        // Assert
        verifyNoInteractions(notificationService);
    }
}