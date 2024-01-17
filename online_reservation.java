import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

class Reservation {
    private String trainNumber;
    private String trainName;
    private String classType;
    private String dateOfJourney;
    private String from;
    private String to;

    public Reservation(String trainNumber, String trainName, String classType,
                       String dateOfJourney, String from, String to) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.classType = classType;
        this.dateOfJourney = dateOfJourney;
        this.from = from;
        this.to = to;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public String getClassType() {
        return classType;
    }

    public String getDateOfJourney() {
        return dateOfJourney;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }
}

public class online_reservation {
    private static Map<String, User> users = new HashMap<>();
    private static ArrayList<Reservation> reservations = new ArrayList<>();

    public static void main(String[] args) {

        users.put("admin", new User("admin", "admin123"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (isValidUser(username, password)) {
            showReservationMenu();
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    private static boolean isValidUser(String username, String password) {
        User user = users.get(username);
        return user != null && user.getPassword().equals(password);
    }

    private static void showReservationMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Reservation System");
            System.out.println("2. Cancellation Form");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    makeReservation();
                    break;
                case 2:
                    cancelReservation();
                    break;
                case 3:
                    System.out.println("Logging out. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void makeReservation() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter train number: ");
        String trainNumber = scanner.nextLine();
        
        String trainName = getTrainName(trainNumber);

        System.out.print("Enter class type: ");
        String classType = scanner.nextLine();

        System.out.print("Enter date of journey: ");
        String dateOfJourney = scanner.nextLine();

        System.out.print("Enter source station: ");
        String from = scanner.nextLine();

        System.out.print("Enter destination station: ");
        String to = scanner.nextLine();

        Reservation reservation = new Reservation(trainNumber, trainName, classType, dateOfJourney, from, to);
        reservations.add(reservation);

        System.out.println("Reservation successful!");
    }

    private static String getTrainName(String trainNumber) {
        
        return "Sample Train";
    }

    private static void cancelReservation() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter PNR number for cancellation: ");
        String pnrNumber = scanner.nextLine();

        for (Reservation reservation : reservations) {
            if (reservation.getTrainNumber().equals(pnrNumber)) {
                reservations.remove(reservation);
                System.out.println("Cancellation successful!");
                return;
            }
        }

        System.out.println("No reservation found with the given PNR number.");
    }
}
