package decorator;

public class ChocolateDecorator extends BevarageDecorator {
    public ChocolateDecorator(Bevarage bevarage) {
        super(bevarage);
     }
    
     @Override
     public String getDescription() {
        return bevarage.getDescription() + ", Chocolate";
     }

     @Override
     public double getCost() {
        return bevarage.getCost() + 0.8;
     }
}
