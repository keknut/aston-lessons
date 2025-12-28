package App;
import decorator.*;

public class Decorator {
    public static void main(String[] args) {
        Bevarage coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + ": " + coffee.getCost());

        Bevarage coffeeWithMilk = new MilkDecorator(new SimpleCoffee());
        System.out.println(coffeeWithMilk.getDescription() + ": " + coffeeWithMilk.getCost());

        Bevarage coffeeFancy = new ChocolateDecorator(
            new SugarDecorator(
            new MilkDecorator(
            new SimpleCoffee())));

        System.out.println(coffeeFancy.getDescription() + ": " + coffeeFancy.getCost());
    }
}
