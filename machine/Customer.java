package machine;

public class Customer {
    public void buy(CoffeeMachine coffeeMachine, Menu menu) {
        try {
            menu.buy(coffeeMachine);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
