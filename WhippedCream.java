public class WhippedCream extends CoffeeDecorator {
    public WhippedCream(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String printCoffee() {
        String a = this.coffee.printCoffee();
        String b = " with whipped cream";
        return (a + b);
    }
}
