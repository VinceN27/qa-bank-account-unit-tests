package com.banking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


@DisplayName("UserLogin Test")
public class UserLoginTest {
    private UserLogin user;

    @BeforeEach
    void setUp(){
         user = new UserLogin("User123", "Password123");
    }

    //Valid Login
    @Test
    @DisplayName("Valid Login Credentials return true")
    void valid_login_credentials_returnTrue(){
    //Arrange
    //Act
    boolean result = user.login("User123", "Password123");
    //Assert
    assertTrue(result);
    }

    //Wrong Password
    @Test
    @DisplayName("Wrong password return false")
    void wrongPassword_returnFalse(){
        //Arrange
        //Act
        boolean result = user.login("User123", "password12");
        //Assert
        assertFalse(result);
    }

    // Wrong Username
    @Test
    @DisplayName("Wrong username returns false")
    void wrongUsername_returnsFalse() {
        // Arrange
        // Act
        boolean result = user.login("WrongUser", "Password123");
        
        // Assert
        assertFalse(result);
    }   

    //Empty userName
    @Test
    @DisplayName("Empty Username throws exception")
    void emptyUserName_throwsException(){
        //Arrange
        //Act //Act Assert
        assertThrows(IllegalArgumentException.class, () -> user.login("", "Password123"));
    }

    //Empty passWord
    @Test
    @DisplayName("Empty Password throws exception")
    void emptyPassword_throwsException(){
        //Arrange
        //Act Assert
        assertThrows(IllegalArgumentException.class, () -> user.login("User123", ""));
    }

    //Password too short
    @Test
    @DisplayName("Password too short throws an exception")
    void passwordTooShort_throwsException(){
        //Arrange
        //Act Assert
        assertThrows(IllegalArgumentException.class, () -> user.login("User123", "pass"));
    }

    //Null userName
    @Test
    @DisplayName("Null Username throws exception")
    void nullUserName_throwsException(){
        //Arrange
        //Act //Act Assert
        assertThrows(IllegalArgumentException.class, () -> user.login(null, "Password123"));
    }


    //null passWord
    @Test
    @DisplayName("Null Password throws exception")
    void nullPassword_throwsException(){
        //Arrange
        //Act Assert
        assertThrows(IllegalArgumentException.class, () -> user.login("User123", null));
    }    
    


}
