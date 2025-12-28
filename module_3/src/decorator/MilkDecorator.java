package decorator;

public class MilkDecorator extends BevarageDecorator {

    public MilkDecorator(Bevarage bevarage) {
        super(bevarage);
    }
    
    @Override
    public String getDescription() {
        return bevarage.getDescription() + ", Milk";
    }

    @Override
    public double getCost() {
        return bevarage.getCost() + 0.5;
    }
}
