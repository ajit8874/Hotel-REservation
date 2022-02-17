package model;

public class FreeRoom extends Room{
//Room should have roomNumber ,roomType and roomPrice
    public FreeRoom(String roomNumber , RoomType roomType,Double roomPrice){
        super(roomNumber,roomType,roomPrice);
         this.roomPrice=0.0;
    }

    public String toString(){

        return super.toString()+"this room is free.";
    }


}
