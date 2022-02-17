import api.AdminResource;
import api.HotelResource;
import model.IRoom;
import model.Reservation;
import model.Room;
import model.RoomType;
import org.w3c.dom.ls.LSOutput;
import service.CustomerService;
import service.ReservationService;

import java.text.ParseException;
import java.util.*;

public class AdminMenu {


    private static String roomNumber;

    // for choosing the option
    public static boolean chooseAnOption(Integer option) {
        boolean whileTrue = false;

        while (!whileTrue) {

            switch (option) {
                case 1:
                    SeeAllCustomer();
                    whileTrue = true;
                    break;
                case 2:
                    SeeAllRooms();
                    whileTrue = true;

                    break;
                case 3:
                    SeeAllReservation();
                    whileTrue = true;

                    break;
                case 4:
                    AddARoom();
                    whileTrue = true;

                    break;
                case 5:
                    //backToMainMenu();
                    whileTrue = true;


                    break;

                default:
                    System.out.println("");
                    whileTrue = true;
            }


        }

        return whileTrue;
    }

    // i am calling displayallreservation method  from adminResource
    private static void SeeAllReservation() {
        AdminResource.displayAllReservation();


    }

    // for adding room  i need room number,roomprice and roomType (like sinle or double)
    private static void AddARoom() {

        Scanner sc = new Scanner(System.in);
        String roomNumber = null;

        //For roomNumber
        boolean flagRoomNumber = true;
        while (flagRoomNumber) {

            try {
                System.out.println("enter roomNumber");
                roomNumber = sc.next();
                IRoom roomNo = HotelResource.getRoom(roomNumber);
                System.out.println(roomNo);
                if (roomNo == null) {
                    flagRoomNumber = false;
                } else {
                    System.out.println("Invalid room number please try again");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("inValid input");
            }
        }


        // for roomType

        boolean flagRoomType = true;
        RoomType roomType = null;
        while (flagRoomType) {

            try {

                System.out.println("Enter roomType");
                String s3 = sc.next();
                if (s3.equals("SINGLE")) {
                    roomType = (RoomType.SINGLE);

                    flagRoomType = false;

                } else if (s3.equals("DOUBLE")) {
                    roomType = RoomType.DOUBLE;
                    flagRoomType = false;

                } else {
                    System.out.println("please select Single or Double");

                }
            } catch (Exception e) {
                System.out.println("Error, Invalid Room Type");
            }

        }


        boolean flagPrice = true;

        Double roomPrice = 0.0;
        while (flagPrice) {
            try {
                System.out.println("Enter the roomPrice");
                roomPrice = sc.nextDouble();
                System.out.println(roomPrice);
                if (roomPrice <= 0.0) {
                    System.out.println("This is not valid price please select valid price");

                } else {
                    flagPrice = false;
                }

            } catch (Exception e) {
                System.out.println("Error invalid price input");
            }
        }

        IRoom room = new Room(roomNumber, roomType, roomPrice);
        ReservationService.addRoom(room);
        System.out.println(room);


        allMenu();
    }

    // i am calling getAllRoom from AdminResource
    private static void SeeAllRooms() {

        List<IRoom> list = new ArrayList<>(AdminResource.getAllRoom());
        if (list.isEmpty()) {
            System.out.println("No Rooms Assign");
        } else {
            System.out.println(list);
        }

    }

    // I am calling getAllCustomer from admin resource
    private static void SeeAllCustomer() {
        System.out.println(AdminResource.getAllCustomer());
        allMenu();

    }

    // these are all menu for selection
    public static void allMenu() {

        System.out.println("Select an option");

        System.out.println("1. See All Customer");

        System.out.println("2. See All Rooms");

        System.out.println("3. See All Reservation");

        System.out.println("4. Add a Room");

        System.out.println("5. Back to main menu");

        Scanner sc = new Scanner(System.in);
        chooseAnOption(sc.nextInt());

    }


}
