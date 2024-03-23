package machine;


public class CoffeeMachine {

    private int amountOfWater;
    private int amountOfMilk;
    private int amountOfCoffeeBean;
    private int disposableCups;
    private int totalIncome;


    public CoffeeMachine(int amountOfWater, int amountOfMilk, int amountOfCoffeeBean, int amountOfCups, int basedMoney) {
        this.amountOfWater = amountOfWater;
        this.amountOfMilk = amountOfMilk;
        this.amountOfCoffeeBean = amountOfCoffeeBean;
        this.disposableCups = amountOfCups;
        this.totalIncome = basedMoney;
    }

    public int getAmountOfWater() {
        return amountOfWater;
    }

    public int getAmountOfMilk() {
        return amountOfMilk;
    }

    public int getAmountOfCoffeeBean() {
        return amountOfCoffeeBean;
    }

    public int getDisposableCups() {
        return disposableCups;
    }

    public int getTotalIncome() {
        return totalIncome;
    }


    public void setAmountOfWater(int amountOfWater) {
        this.amountOfWater = amountOfWater;
    }

    public void setAmountOfMilk(int amountOfMilk) {
        this.amountOfMilk = amountOfMilk;
    }

    public void setAmountOfCoffeeBean(int amountOfCoffeeBean) {
        this.amountOfCoffeeBean = amountOfCoffeeBean;
    }

    public void setDisposableCups(int disposableCups) {
        this.disposableCups = disposableCups;
    }

    public void setTotalIncome(int totalIncome) {
        this.totalIncome = totalIncome;
    }


    public void printStatus() {
        System.out.println("\nThe coffee machine has:");
        System.out.printf("%d ml of water\n", this.amountOfWater);
        System.out.printf("%d ml of milk\n", this.amountOfMilk);
        System.out.printf("%d g of coffee beans\n", this.amountOfCoffeeBean);
        System.out.printf("%d disposable cups\n", this.disposableCups);
        System.out.printf("$%d of money\n\n", this.totalIncome);
    }
}
