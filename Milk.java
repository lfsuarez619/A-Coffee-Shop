class Milk extends CoffeeDecorator{
    public Milk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String printCoffee() {
        String a = this.coffee.printCoffee();
        String b = " with milk";
        return (a + b);
    }
    public void BasicCoffee() {

    }

}
