package model;

import java.util.Date;

public class Reservation {

    Customer customer;
    IRoom room;
    Date checkInDate;
    Date checkOutDate;

//    public Reservation(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
//    }


    public  Reservation(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
        this.customer=customer;
        this.room=room;
        this.checkInDate=checkInDate;
        this.checkOutDate=checkOutDate;




    }

    public Date getCheckOutDate() {
        return this.checkOutDate;
    }

    public  Date getCheckInDate(){

        return this.checkInDate;
    }

    public IRoom getRoomInterface() {
        return  this.room;
    }
}
