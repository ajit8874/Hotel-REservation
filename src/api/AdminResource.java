package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class AdminResource {


    private static HashMap<String ,Customer> customers=new HashMap<>();
    private static HashMap<String ,IRoom> allrooms=new HashMap<>();


// for getting Customer i am calling the method getCustomer from CustomerService
    public static Customer getCustomer(String email){
        return CustomerService.getCustomer(email);


    }

//adding a room
    public  static void addRoom(List<IRoom> rooms){
        //return ReservationService.addRoom(rooms);
        //return ReservationService.addRoom(rooms);
   // iterating in rooms and reservation object
        ReservationService reservationService=new ReservationService();
        for(IRoom  addOfRoom: rooms){
            reservationService.addRoom(addOfRoom);

        }

    }


// for getting these three getAllRoom ,getAllCustomer and displayAllReservation i am caalling method from ReservationService
    // and CustomerService and Reservation


    public static Collection<IRoom> getAllRoom(){
         return ReservationService.getAllRooms();

    }


    public static Collection<Customer> getAllCustomer(){
        return  CustomerService.getAllCustomers();

    }


    public static void displayAllReservation(){
        ReservationService.printAllReservation();


    }

}
