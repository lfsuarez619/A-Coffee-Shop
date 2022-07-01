/**
 * Lab 2
 * Generates the general layout of the order system by displaying class design, base classes, and method stubs
 * CS160 Lab - Summer 2022
 * 06/04/22
 * @author Katelin Jaque and Luis Suarez
 */
public class Main {
    public static void main(String[] args) {

        Coffee coffee = new BlackCoffee(new BasicCoffee());
        System.out.println(coffee.printCoffee());
        Coffee coffeeWithMilk = new Milk(new BlackCoffee(new BasicCoffee()));
        System.out.println(coffeeWithMilk.printCoffee());

    }

}
