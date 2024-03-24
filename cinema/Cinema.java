package cinema;

import java.util.Objects;
import java.util.Scanner;


/*
 * This Java-based Cinema Theatre Management System was developed as an educational project
 * to automate and streamline operations in a cinema environment.
 * It incorporates essential Java concepts like input/output operations, data management using arrays,
 * and logical structuring with functions, loops, and conditional statements.
 */


public class Cinema {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String SEAT = "S";
    private static final String BOOKED = "B";
    private static final int HIGH_PRICE = 10;
    private static final int LOW_PRICE = 8;
    private static int curruntIncome;
    private static int purchsedTicket;


    public static void main(String[] args) {

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();

        // Create a cinema
        String[][] cinema = createCinema(rows, seats);

        // Select an option from the menu:
        selectOption(cinema, rows, seats);



    }

    private static void showStatistics(int rows, int seats) {
        double percentage = (double) purchsedTicket / (rows * seats) * 100;
        int totalIncome = rows * seats < 60 ? HIGH_PRICE * rows * seats
                : rows / 2 * seats * HIGH_PRICE + (rows - rows / 2) * seats * LOW_PRICE;

        System.out.printf("\nNumber of purchased tickets: %d\n", purchsedTicket);
        System.out.printf("Percentage: %.2f%%\n", percentage);
        System.out.printf("Current income: $%d\n", curruntIncome);
        System.out.printf("Total income: $%d\n", totalIncome);
    }

    private static void selectOption(String[][] cinema, int rows, int seats) {
        while (true) {
            System.out.println("\n1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "3. Statistics\n" +
                    "0. Exit");
            int selection = scanner.nextInt();

            if (selection == 0) {
                break;
            }

            switch (selection) {
                case 1 -> displaySeats(cinema);
                case 2 -> reserveSeat(rows, seats, cinema);
                case 3 -> showStatistics(rows, seats);
            }
        }
    }

    // Reserve a seat and check the ticket price
    private static void reserveSeat(int rows, int seats, String[][] cinema) {

        while (true) {
            System.out.println("\nEnter a row number:");
            int rowNum = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            int seatNum = scanner.nextInt();
            scanner.nextLine();

            if (rowNum > rows || seatNum > seats) {
                System.out.println("\nWrong input!");
                continue;
            }


            if (!Objects.equals(cinema[rowNum][seatNum], BOOKED)) {
                int ticketPrice = getTicketPrice(rows, seats, rowNum);

                System.out.println("Ticket price: $" + ticketPrice);
                cinema[rowNum][seatNum] = BOOKED;
                purchsedTicket += 1;
                curruntIncome += ticketPrice;
                return;
            } else {
                System.out.println("\nThat ticket has already been purchased!");
            }
        }
    }

    private static int getTicketPrice(int rows, int seats, int rowNum) {
        int ticketPrice = (rows * seats < 60 || rowNum <= rows / 2) ? HIGH_PRICE : LOW_PRICE;
        return ticketPrice;
    }

    // Display the available seats in the cinema.
    private static void displaySeats(String[][] cinema) {
        System.out.println("\nCinema:");
        for (String[] row : cinema) {
            for (String seat : row) {
                System.out.print(seat + " ");
            }
            System.out.println();
        }
    }


    private static String[][] createCinema(int rows, int seats) {
        String[][] cinema = new String[rows + 1][seats + 1];
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= seats; j++) {
                if (i == 0) {
                    cinema[i][j] = j == 0 ? " " : Integer.toString(j);
                } else {
                    cinema[i][j] = j == 0 ? Integer.toString(i) : SEAT;
                }
            }
        }
        return cinema;
    }
}