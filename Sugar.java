public class Sugar extends CoffeeDecorator{
    public Sugar(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String printCoffee() {
        String a = this.coffee.printCoffee();
        String b = " with sugar";
        return (a + b);
    }
}
