import java.util.Scanner;

public class movie {
    static String[] seats = new String[10];

    // Display seats
    static void displaySeats() {
        System.out.println("\n===== SCREEN =====");
        for (int i = 0; i < seats.length; i++) {
            System.out.print("[" + seats[i] + "] ");
            if ((i + 1) % 5 == 0) {
                System.out.println();
            }
        }
        System.out.println("\nNumbers = Available   X = Booked");
    }

    // Book multiple seats
    static void bookSeats(int count, Scanner sc) {
        for (int i = 1; i <= count; i++) {
            System.out.print("Enter seat number " + i + ": ");
            int seatNumber = sc.nextInt();

            if (seatNumber < 1 || seatNumber > 10) {
                System.out.println("Invalid seat number!");
                i--;
            } 
            else if (seats[seatNumber - 1].equals("X")) {
                System.out.println("Seat already booked!");
                i--;
            } 
            else {
                seats[seatNumber - 1] = "X";
                System.out.println("Seat " + seatNumber + " booked successfully!");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Initialize seats with numbers
        for (int i = 0; i < seats.length; i++) {
            seats[i] = String.valueOf(i + 1);
        }

        int choice;

        do {
            displaySeats();

            System.out.println("\n1. Book Seats");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("How many seats do you want to book? ");
                    int count = sc.nextInt();
                    bookSeats(count, sc);
                    break;

                case 2:
                    System.out.println("Thank you for using Movie Ticket Booking System!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 2);

        sc.close();
    }
}