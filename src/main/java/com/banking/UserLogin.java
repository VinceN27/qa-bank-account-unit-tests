package com.banking;

public class UserLogin {
    private String userName;
    private String password;
    
    public UserLogin(String userName, String password){
        if(userName == null || userName.isEmpty()){
            throw new IllegalArgumentException("UserName is blank");
        }

        if(password == null || password.isEmpty()){
            throw new IllegalArgumentException("Password is blank");
        }

        if(password.length() < 6){
            throw new IllegalArgumentException("Password must be 6 characters");
        }

        this.userName = userName;
        this.password = password;
    }

    public boolean login (String userName, String password){
        if(userName == null || userName.isEmpty()){
            throw new IllegalArgumentException("UserName is blank");
        }

        if(password == null || password.isEmpty()){
            throw new IllegalArgumentException("Password is blank");
        }

        /*
        if(password.length() < 6){
            throw new IllegalArgumentException("Password must be 6 characters");
        }
         */
        
        return this.userName.equals(userName) && this.password.equals(password);
    }

    public String getUserName(){
        return userName;
    }
}
