package decorator;

public class SimpleCoffee implements Bevarage {
    
    @Override
    public String getDescription() {
        return "Simple Coffee";
    }
    
    @Override
    public double getCost() {
        return 1.0;
    }
}
