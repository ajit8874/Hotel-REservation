package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import model.Room;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

public class HotelResource {

//getting getCustomer method from CustomerService Class
    public static Customer getCustomer(String email){

        return CustomerService.getCustomer(email);

    }

    // customer should have email ,firstName and lastName
    public static void createACustomer(String email,String firstName,String lastName){
         CustomerService.addCustomer(email,firstName,lastName);

    }
//calling getRoom method from ReservationService class
    public static IRoom getRoom(String roomNumber){
        return ReservationService.getARoom(roomNumber);


    }
// calling reserveARoom from ReservationService and same i am calling method from anothe classes in below two method also.
    public static Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate,Date checkOutDate){
        return ReservationService.reserveARoom(getCustomer(customerEmail),room,checkInDate,checkOutDate);



    }

    public static Collection<IRoom> findARoom(Date checkIn,Date checkOut){
        return ReservationService.findRoom(checkIn,checkOut);


    }

    public static Collection<Reservation> getCustomerReservation(String customerEmail){
        return ReservationService.getCustomerReservation(getCustomer(customerEmail));
    }
}
