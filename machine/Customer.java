package machine;

public class Customer {
    public void buy(CoffeeMachine coffeeMachine, Menu menu) {

        if (coffeeMachine.getAmountOfWater() < menu.waterPerCup) System.out.println("Sorry, not enough water!");
        else if (coffeeMachine.getAmountOfMilk() < menu.milkPerCup) System.out.println("Sorry, not enough Milk!");
        else if (coffeeMachine.getAmountOfCoffeeBean() < menu.coffeeBeanPerCup)
            System.out.println("Sorry, not enough Coffee beans!");
        else if (coffeeMachine.getDisposableCups() < 1) System.out.println("Sorry, not enough cups!");
        else {
            System.out.println("I have enough resources, making you a coffee!\n");
            coffeeMachine.setAmountOfWater(coffeeMachine.getAmountOfWater() - menu.waterPerCup);
            coffeeMachine.setAmountOfMilk(coffeeMachine.getAmountOfMilk() - menu.milkPerCup);
            coffeeMachine.setAmountOfCoffeeBean(coffeeMachine.getAmountOfCoffeeBean() - menu.coffeeBeanPerCup);
            coffeeMachine.setDisposableCups(coffeeMachine.getDisposableCups() - 1);
            coffeeMachine.setTotalIncome(coffeeMachine.getTotalIncome() + menu.pricePerCup);
        }
    }
}
