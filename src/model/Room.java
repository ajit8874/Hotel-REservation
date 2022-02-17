package model;

public class Room implements IRoom{

     String roomNumber;
     Double roomPrice;
     RoomType enumeration;

    public Room(String roomNumber, RoomType enumeration, Double roomPrice){

        this.roomNumber=roomNumber;
        this.roomPrice=roomPrice;
        this.enumeration=enumeration;

    }

    @Override
    public String getRoomNumber() {

        return this.roomNumber;
    }
    public String setRoomNumber(String roomNumber){
        return this.roomNumber=roomNumber;

    }


    @Override
    public Double getRoomPrice() {

        return roomPrice;
    }

    public  void setRoomPrice(Double roomPrice){
        this.roomPrice=roomPrice;
    }


    @Override
    public RoomType getRoomType() {

        return enumeration;
    }

    @Override
    public boolean isFree() {
        return false ;
    }

    @Override
    public String toString(){
        return "roomNumber"+ roomNumber +"roomPrice"+roomPrice+"roomType"+ enumeration +"isFree"+ false;
    }

}
