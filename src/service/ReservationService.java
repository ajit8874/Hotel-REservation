package service;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

public class ReservationService {

    private static HashMap<String ,IRoom> totalRooms=new HashMap<>();

    private static HashMap<String,Collection<Reservation>> totalReservation=new HashMap<>();
//
    public static void addRoom(IRoom room){
        System.out.println(totalRooms.get(room));
        totalRooms.put(room.getRoomNumber(),room);

    }
// for getting any room we should have unique id that is roomId
    public static IRoom getARoom(String roomId){

        if(totalRooms.containsKey(roomId)){
            return totalRooms.get(roomId);
        }
        else{
            return  null;
        }

    }

//For reserve any room first ofall checkinData and checkOutDate is compalsory beacuase without confirming date we can't book any room
    public static  Reservation reserveARoom(Customer customer , IRoom room , Date checkInDate, Date checkOutDate){
    //reservation is an obeject of Reservation claas and i am taking help of arraylist for storing totalReservation

        Reservation reservation=new Reservation(customer, room,checkInDate,checkOutDate);

        Collection<Reservation> totalReservations=new ArrayList<>();

//        if(totalReservations==null){
//            totalReservations=new ArrayList<>();
//
//
//        }
//        else{
//            totalReservations.add(reservation);
//            totalReservation.put(customer.getEmail(),totalReservations);
//            return reserawvation;
//        }

//
            totalReservations.add(reservation);
            totalReservation.put(customer.getEmail(),totalReservations);
            return reservation;


    }
// i am finding room  and checkInDate and checkOutDate is compalsory for find any room
    public static Collection<IRoom> findRoom(Date checkInDate, Date checkOutDate){
        // i am checking that hoe many rooms are available
        Collection<IRoom> availableRooms = getAllRooms();
        Collection<Reservation> BoockedReservations =getAllReservation();

        for(Reservation searchRoom :BoockedReservations){
            if(checkInDate.before(searchRoom.getCheckOutDate()) && checkOutDate.after(searchRoom.getCheckInDate())
            || searchRoom.getCheckInDate().before(checkInDate) && searchRoom.getCheckOutDate().after(checkOutDate)){

                availableRooms.remove(searchRoom.getRoomInterface());


            }
        }
        return availableRooms;





    }

    public static Collection<IRoom> getAllRooms(){

        return totalRooms.values();
    }


    public static Collection<Reservation> getAllReservation() {
        Collection<Reservation>  allReservation =new ArrayList<>();
        for(Collection<Reservation> totReservation :totalReservation.values()){
            allReservation.addAll(totReservation);

        }
        return allReservation;
       // return  totalReservation.values();
    }

    public static Collection<Reservation> getCustomerReservation(Customer customer){
        return totalReservation.get(customer.getEmail());


    }

    public  static  void printAllReservation(){
        for(Collection<Reservation> allreservation: totalReservation.values()){
            System.out.println(allreservation);
        }


    }





}
