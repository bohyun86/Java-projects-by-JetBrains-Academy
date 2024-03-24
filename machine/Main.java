package machine;

import machine.menu.Cappuccino;
import machine.menu.Espresso;
import machine.menu.latte;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 영업 개시
        getStarted();

    }

    private static void getStarted() {
        Scanner scanner = new Scanner(System.in);

        // 커피머신 초기화
        CoffeeMachine coffeeMachine = CoffeeMachine.getInstance(400, 540, 120, 9, 550);

        // 메뉴 생성
        Menu espresso = new Espresso(250,0,16,4);
        Menu latte = new latte(350,75,20,7);
        Menu cappuccino = new Cappuccino(200, 100, 12, 6);

        // 점원 및 고객 생성
        Clerk clerk = new Clerk();
        Customer customer = new Customer();
        boolean isClosed = false;
        while (!isClosed) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.nextLine();
            switch (action) {
                case "buy" -> {
                    System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                    String menu = scanner.nextLine();
                    switch (menu) {
                        case "1" -> customer.buy(coffeeMachine, espresso);
                        case "2" -> customer.buy(coffeeMachine, latte);
                        case "3" -> customer.buy(coffeeMachine, cappuccino);
                        case "back" -> System.out.println();
                        default -> System.out.println("That menu is not available.\n");
                    }
                }
                case "fill" -> clerk.fill(coffeeMachine);
                case "take" -> clerk.take(coffeeMachine);
                case "remaining" -> coffeeMachine.printStatus();
                case "exit" -> isClosed = true;
            }
        }
    }
}
