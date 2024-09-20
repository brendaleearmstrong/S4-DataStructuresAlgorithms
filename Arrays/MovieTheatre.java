import java.util.Scanner;

public class MovieTheatre {
    private final String[][] seats;  // Stores the name of the person who reserves the seat or "Available"

    // Constructor to initialize the seating chart
    public MovieTheatre(int rows, int cols) {
        seats = new String[rows][cols];
        initializeSeatingChart();
    }

    // Initialize seating chart with all available seats
    private void initializeSeatingChart() {
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                seats[i][j] = "Available";  // Initially all seats are available
            }
        }
    }

    // Display the seating chart with rows as numbers and columns as letters
    public void displaySeatingChart() {
        System.out.println("\nCurrent Seating Chart:");
        System.out.print("   ");

        // Print column headers (A, B, C, etc.)
        for (int col = 0; col < seats[0].length; col++) {
            System.out.print((char) ('A' + col) + " ");
        }
        System.out.println();

        // Print rows (1, 2, 3, ...) and seats
        for (int row = 0; row < seats.length; row++) {
            System.out.print((row + 1) + ": ");  // Row numbers start at 1
            for (int col = 0; col < seats[row].length; col++) {
                // Show 'Available' or the name of the person who reserved the seat
                System.out.print((seats[row][col].equals("Available") ? "A" : "X") + " ");
            }
            System.out.println();
        }
    }

    // Display available seats with row numbers and seat letters
    public void displayAvailableSeats() {
        System.out.println("\nAvailable Seats:");
        for (int row = 0; row < seats.length; row++) {
            for (int col = 0; col < seats[row].length; col++) {
                if (seats[row][col].equals("Available")) {
                    System.out.println("Row " + (row + 1) + " Seat " + (char) ('A' + col));
                }
            }
        }
    }

    // Reserve a seat with the user's name if available
    public void reserveSeat(int row, int col, String name) {
        if (!isValidSeat(row, col)) {
            System.out.println("Invalid seat number. Please try again.");
            return;
        }
        if (!seats[row][col].equals("Available")) {
            System.out.println("Sorry, the seat is already reserved.");
        } else {
            seats[row][col] = name;  // Reserve the seat with the user's name
            System.out.println("Seat reserved successfully for " + name + ".");
        }
    }

    // Cancel a reserved seat
    public void cancelSeat(int row, int col) {
        if (!isValidSeat(row, col)) {
            System.out.println("Invalid seat number. Please try again.");
            return;
        }
        if (seats[row][col].equals("Available")) {
            System.out.println("The seat is not reserved.");
        } else {
            System.out.println("Reservation for " + seats[row][col] + " has been cancelled.");
            seats[row][col] = "Available";  // Reset to available
        }
    }

    // Validate if the seat exists within the chart
    private boolean isValidSeat(int row, int col) {
        return row >= 0 && row < seats.length && col >= 0 && col < seats[row].length;
    }

    // Main CLI menu to interact with the theatre system
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieTheatre theatre = new MovieTheatre(5, 5);  // 5 rows and 5 columns for demo
        boolean running = true;

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Display Seating Chart");
            System.out.println("2. Display Available Seats");
            System.out.println("3. Reserve a Seat");
            System.out.println("4. Cancel a Reservation");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    theatre.displaySeatingChart();
                    break;
                case 2:
                    theatre.displayAvailableSeats();
                    break;
                case 3:
                    System.out.print("Enter row number to reserve (1-" + theatre.seats.length + "): ");
                    int rowReserve = scanner.nextInt() - 1;  // Convert to 0-based index
                    System.out.print("Enter seat letter to reserve (A-" + (char) ('A' + theatre.seats[0].length - 1) + "): ");
                    char colReserveChar = scanner.next().charAt(0);
                    int colReserve = colReserveChar - 'A';  // Convert letter to 0-based index
                    System.out.print("Enter your name: ");
                    String name = scanner.next();
                    theatre.reserveSeat(rowReserve, colReserve, name);
                    break;
                case 4:
                    System.out.print("Enter row number to cancel (1-" + theatre.seats.length + "): ");
                    int rowCancel = scanner.nextInt() - 1;  // Convert to 0-based index
                    System.out.print("Enter seat letter to cancel (A-" + (char) ('A' + theatre.seats[0].length - 1) + "): ");
                    char colCancelChar = scanner.next().charAt(0);
                    int colCancel = colCancelChar - 'A';  // Convert letter to 0-based index
                    theatre.cancelSeat(rowCancel, colCancel);
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
