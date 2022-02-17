package service;

import model.Customer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class CustomerService {

    public static HashMap<String,Customer> customers = new HashMap<>();




// I a msdding customer which has email ,firstname and lastName
    public static void addCustomer(String email,String firstName,String lastName){
 // customer is an object of Customer class
        Customer customer =new Customer(firstName,lastName,email);
        customers.put(email,customer);

    }

    //I can get the customer with the help of email only
    public static Customer getCustomer(String CustomerEmail){
       // System.out.println("++++++"+CustomerEmail);
        return customers.get(CustomerEmail);

    }
//I am getting all the customer with the help of Collection and arrayList and with the help of .values() i am getting value of map.
    public static  Collection<Customer> getAllCustomers(){
        return new ArrayList<>(customers.values());
    }




}
