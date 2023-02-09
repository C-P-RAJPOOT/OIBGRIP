import java.util.Scanner;
import java.util.HashMap;

public class OnlineReservationSystem {
static Scanner sc = new Scanner(System.in);
static String username, password;
static HashMap<String, String> users = new HashMap<>();
static HashMap<String, String> reservations = new HashMap<>();
static void login() {
    System.out.println("Enter userId: ");
    username = sc.nextLine();
    System.out.println("Enter password: ");
    password = sc.nextLine();

    if (users.containsKey(username) && users.get(username).equals(password)) {
        System.out.println("Login successful!");
    } else {
        System.out.println("Incorrect username or password. Please try again.");
    }
}

static void addUser() {
    System.out.println("Enter a username: ");
    username = sc.nextLine();
    System.out.println("Enter a password: ");
    password = sc.nextLine();
    users.put(username, password);
    System.out.println("User added successfully.");
}

static void makeReservation() {
    System.out.println("Enter room number: ");
    String roomNumber = sc.nextLine();
    System.out.println("Enter date of reservation: ");
    String date = sc.nextLine();
    reservations.put(roomNumber, date);
    System.out.println("Reservation made successfully.");
}
static void cancel(){
    System.out.println("If  you want to cancel reservation then enter room number:");
}

static void cancelReservation() {
    System.out.println("Enter room number: ");
    String roomNumber = sc.nextLine();
    if (reservations.containsKey(roomNumber)) {
        reservations.remove(roomNumber);
        System.out.println("Reservation cancelled successfully.");
    } else {
        System.out.println("No reservation found for room number " + roomNumber + ".");
    }
}

public static void main(String[] args) {
    String b= "No";
    addUser();
    System.out.println("your userId is:"+ username+"\n");
    login();
    makeReservation();
    cancel();
    cancelReservation();
   
    
    
    
    
}
}