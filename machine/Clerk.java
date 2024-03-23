package machine;

import java.util.Scanner;

public class Clerk {

    private int todayIncome = 0;
    public void fill(CoffeeMachine coffeeMachine) {
        Scanner scanner = new Scanner(System.in);
        int water;
        int milk;
        int coffeeBean;
        int cups;

        System.out.println("\nWrite how many ml of water you want to add: ");
        water = scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        coffeeBean = scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add: ");
        cups = scanner.nextInt();
        System.out.println();

        coffeeMachine.setAmountOfWater(coffeeMachine.getAmountOfWater() + water);
        coffeeMachine.setAmountOfMilk(coffeeMachine.getAmountOfMilk() + milk);
        coffeeMachine.setAmountOfCoffeeBean(coffeeMachine.getAmountOfCoffeeBean() + coffeeBean);
        coffeeMachine.setDisposableCups(coffeeMachine.getDisposableCups() + cups);


    }

    public void take(CoffeeMachine coffeeMachine) {
        this.todayIncome = coffeeMachine.getTotalIncome();
        System.out.printf("\nI gave you $%d\n\n", coffeeMachine.getTotalIncome());
        coffeeMachine.setTotalIncome(0);
    }
}
