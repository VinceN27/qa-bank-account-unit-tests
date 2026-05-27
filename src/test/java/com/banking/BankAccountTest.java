package com.banking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


@DisplayName("BankAccount Tests")
class BankAccountTest {
	//Initialize Bank Account
	private BankAccount account;
	
	//Initialize starting ammount
	@BeforeEach
	void setUp (){
		account = new BankAccount(100.0);
	}

	//Valid Withdrawal
	@Test
	@DisplayName("Valid Withdrawal decreases balance")
	void valid_withdrawal_decreasesBalance(){
		//Arrange - account set up with $100
		
		//Act
		account.withdraw(60.0);
		
		//Assert
		assertEquals(40.0, account.getBalance());
	}

	//Invalid Withdrawal 
	@Test
	@DisplayName("Withdrawal more than balance throws exception")
	void withdrawal_moreThanBalance_throwsException(){
		assertThrows(IllegalStateException.class, () 
				-> account.withdraw(101.0));
	}	


	//Invalid Zero Withdrawal
	@Test
	@DisplayName("Withdrawal of Zero throws exception")
	void zero_withdrawalAmount_throwsException(){
		assertThrows(IllegalArgumentException.class,
				() -> account.withdraw(0.0));
	}		

	//Invalid Negative withdrawal
	@Test
	@DisplayName("Withdrawal of negative throws exception")
	void negative_withdrawalAmount_throwsException(){
		assertThrows(IllegalArgumentException.class,
				() -> account.withdraw(-20.0));
	}		



	//Withdrawal equals current amount
	@Test
	@DisplayName("Maximum Withdrawal Amount")
	void maximum_withdrawalAmount(){
		//Arrange
		//Act
		account.withdraw(100.0);

		//Assert
		assertEquals(0.0 ,account.getBalance());
	}




	//Valid Deposit
	@Test
	@DisplayName("Valid Deposit increases balance")
	void valid_deposit_increasesBalance(){
		//Arrange - account set up with $100
		
		//Act
		account.deposit(50);
		
		//Assert
		assertEquals(150.0 ,account.getBalance());
	}
	
	//Invalid Deposit Negative
	@Test
	@DisplayName("Deposit Negative Amount throws exception")
	void deposit_negativeAmount_throwsException(){
		assertThrows(IllegalArgumentException.class,
				() -> account.deposit(-20.0));
	}


	//Invalid Deposit Zero deposit
	@Test
	@DisplayName("Deposit Zero Amount throws exception")
	void zero_depositAmount_throwsException(){
		assertThrows(IllegalArgumentException.class,
				() -> account.deposit(0.0));
	}	

	
	
	//BankAccount Negative Balance
	@Test
	@DisplayName("Bank account with negative Balance")
	void bankAccount_with_negativeBalance(){
		assertThrows(IllegalArgumentException.class, 
				() -> new BankAccount(-50.0));
	}

	//Zero Initial Balance
	@Test
	@DisplayName("Zero initial balance is valid")
	void constructor_zeroBalance_isValid(){
		BankAccount zeroAccount = new BankAccount(0.0);
		assertEquals(0.0, zeroAccount.getBalance());
	}	

}
