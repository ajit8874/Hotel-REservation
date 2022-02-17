package model;

import java.util.regex.Pattern;

public class Customer {
    private final String firstName;
    private final String lastName;
    private final String email;

    private final String emailRegex="^(.+)@(.+).com$";

    Pattern p = Pattern.compile(emailRegex);
    //customer should have firstName , lastName and email ACCORDING TO THE project
    public Customer(String firstName,String lastName,String email){
        this.email=email;
        this.firstName=firstName;
        this.lastName=lastName;
        System.out.println(this.email);
        if(!p.matcher(email).matches()){
            throw new IllegalArgumentException("Input email is not valid");
        }

    }
//overriding all the method
    @Override
    public String toString(){
        return "firstName:"+firstName+"lastName:"+lastName+"Email:"+email;
    }

    public String getEmail() {
        return  this.email;
    }


//    public String getEmail() {
//        return this.email;
//    }
}
