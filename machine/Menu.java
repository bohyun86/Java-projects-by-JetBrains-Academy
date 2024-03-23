package machine;

public class Menu {
    protected int waterPerCup;
    protected int milkPerCup;
    protected int coffeeBeanPerCup;
    protected int pricePerCup;

    public Menu(int waterPerCup, int milkPerCup, int coffeeBeanPerCup, int pricePerCUp) {
        this.waterPerCup = waterPerCup;
        this.milkPerCup = milkPerCup;
        this.coffeeBeanPerCup = coffeeBeanPerCup;
        this.pricePerCup = pricePerCUp;
    }
}
