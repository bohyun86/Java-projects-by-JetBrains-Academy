package machine;

public class Menu implements Buyable {
    protected int waterPerCup;
    protected int milkPerCup;
    protected int coffeeBeanPerCup;
    protected int pricePerCup;

    public Menu(int waterPerCup, int milkPerCup, int coffeeBeanPerCup, int pricePerCup) {
        this.waterPerCup = waterPerCup;
        this.milkPerCup = milkPerCup;
        this.coffeeBeanPerCup = coffeeBeanPerCup;
        this.pricePerCup = pricePerCup;
    }

    @Override
    public void buy(CoffeeMachine coffeeMachine) throws Exception {
        if (coffeeMachine.getAmountOfWater() < waterPerCup) throw new Exception("Sorry, not enough water!");
        if (coffeeMachine.getAmountOfMilk() < milkPerCup) throw new Exception("Sorry, not enough milk!");
        if (coffeeMachine.getAmountOfCoffeeBean() < coffeeBeanPerCup) throw new Exception("Sorry, not enough coffee beans!");
        if (coffeeMachine.getDisposableCups() < 1) throw new Exception("Sorry, not enough cups!");

        coffeeMachine.consumeResources(waterPerCup, milkPerCup, coffeeBeanPerCup, pricePerCup);
        System.out.println("I have enough resources, making you a coffee!\n");
    }
}
