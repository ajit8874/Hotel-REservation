import api.HotelResource;
import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static service.CustomerService.getCustomer;

public class MainMenu {




// this is for selection any option

    //public static boolean selectOption(Scanner sc, Integer option) throws ParseException {
    public  static void mainmenu(){

        //  startHere();

        try{
            Scanner sc =new Scanner(System.in);
            boolean whileTrue = true;


            System.out.println("Hotel Reservation Application System");


            System.out.println("1. Find and reserve a room");


            System.out.println("2. See my reservations");

            System.out.println("3. Create an Account");

            System.out.println("4. Admin");

            System.out.println("5. Exit");

            System.out.println("Please select a number");



            // Scanner sc=new Scanner(System.in);
            int option =Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1:
                    findAndReserveRoom();
                    break;
                case 2:
                    getCustomerReservations();
                    break;
                case 3:
                    createAccount();
                    break;
                case 4:
                    AdminMenu.allMenu();
                    break;
                case 5:
                    whileTrue= false;

                    break;

                default:
                    System.out.println("Select  number between 1 and 5\n");
            }


        }catch ( Exception e){
            e.printStackTrace();
        }

    }

    // for creating the account  i am taking email, firstName, lastname as input
    private static void createAccount() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter you email :");
        String email=sc.next();

        System.out.println("Enter First name :");
        String firstName=sc.next();

        System.out.println("Enter lastName :");
        String lastName=sc.next();

       //Customer customer=new Customer(email,firstName,lastName);
       HotelResource.createACustomer(email,firstName,lastName);


        System.out.println("account created successfully");

        mainmenu();

    }
//  befor do any reservation for checking that we have any reservation or not
    private static Customer getCustomerReservations() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter you email : sajit@gmail.com");
        String email=sc.next();

        Customer customer=HotelResource.getCustomer(email);
        //customer= HotelResource.getCustomer(email);


        if(customer==null){
            System.out.println("you haven't any account please create your account");
            createAccount();
            return null;
        }
        Collection<Reservation> reservations=new ArrayList<>();
        reservations=HotelResource.getCustomerReservation(customer.getEmail());
        //Collection<Reservation> reservations=HotelResource.getCustomerReservation(customer.getEmail());


        for( Reservation bookedRoom :reservations){
            System.out.println(bookedRoom);
        }
        return  customer;





    }
// i am searching that on that date when i want to book the room ,rooms are avialable or not
   // if rooms are avialable then reserve it.
    private static void findAndReserveRoom() {
//taking input date
        Scanner sc=new Scanner(System.in);
        System.out.println("Please select you checkInDate and checkOutDate");


        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        System.out.println("Please enter checkInDate");
        String dt = sc.nextLine();
        Date checkInDate = null;
        Date checkOutDate = null;

        try{
            calendar.setTime(simpleDateFormat.parse(dt));
             checkInDate = calendar.getTime();
            System.out.println(checkInDate);
        }catch (ParseException ex){
            System.out.println("Invalid date");
        }


        System.out.println("Enter checkOut Date");
        String dt1 = sc.nextLine();

       try{
           calendar.setTime(simpleDateFormat.parse(dt1));
           checkOutDate = calendar.getTime();
           System.out.println(checkOutDate);
       }catch(ParseException ex){
           System.out.println("Invalid Date");
       }



        Collection<IRoom> findRoomForReservation = ReservationService.findRoom(checkInDate,checkOutDate);
        // if there will be available room  i am checking here
        if(findRoomForReservation.isEmpty()){
            //Reservation reservation=new Reservation();
            System.out.println("Dou you want to book a room  Y or N :");
            String  s=sc.next();
            if(s.equalsIgnoreCase("y")){
                System.out.println(findRoomForReservation);
                Customer customer = getCustomer();
                System.out.println(customer);
                Reservation reservation=HotelResource.bookARoom(customer.getEmail(), (IRoom) findRoomForReservation,checkInDate,checkOutDate);
                System.out.println("Your room has been booked"+reservation);


            }
            else{
                System.out.println("Thanks for visit");
            }


        }



//       if(checkInDate==null && checkInDate==null){
//           System.out.println("Rooms are not available");
//
//       }
//       else{
//
//
//       }


        //user input checkin dtae and hceout date
        //send to a function
        //find room betwenn date
        //if date are not available extends 7 more days
        //if availabe

    }

    public static Customer getCustomer(){
        Scanner sc=new Scanner(System.in);
        System.out.println("provide your email");
        String s1=sc.next();
        //System.out.println(s1);
        //Customer customer=new Customer("firstName","lastName","email");
        Customer customerService=CustomerService.getCustomer(s1);
        //Customer customer=new Customer();
       // customerService=
        System.out.println(customerService);
       // return customerService;
        return CustomerService.getCustomer(s1);


    }



    //  i am admin menu  here
    private static void  AdminMenu() throws ParseException {

        Scanner sc=new Scanner(System.in);
        boolean admin=false;
        while(!admin){
            AdminMenu.allMenu();
            int n=sc.nextInt();
            admin=AdminMenu.chooseAnOption(n);

        }


    }

    // we are starting the reservation from here it will show the menu
//    public static void startHere(){
//
//        System.out.println("Hotel Reservation Application System");
//
//
//        System.out.println("1. Find and reserve a room");
//
//
//        System.out.println("2. See my reservations");
//
//        System.out.println("3. Create an Account");
//
//        System.out.println("4. Admin");
//
//        System.out.println("5. Exit");
//
//        System.out.println("Please select a number");
//
//    }

}