public class BlackCoffee extends CoffeeDecorator {
    public BlackCoffee(Coffee coffee) {
        super(coffee);
    }
    @Override
    public String printCoffee() {
        String a = "A black coffee";
        return a;
    }
}
