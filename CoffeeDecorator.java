import java.util.Scanner;
public class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    public void addTopping(Coffee coffee) {
        this.coffee.addTopping(coffee);
    }

    public String printCoffee() {
        String z = "";
        return z;
    }
}

