package decorator;

public class SugarDecorator extends BevarageDecorator {
    public SugarDecorator(Bevarage bevarage) {
        super(bevarage);
    }

    @Override
    public String getDescription() {
        return bevarage.getDescription() + ", Sugar";
    }

    @Override
    public double getCost() {
        return bevarage.getCost() + 0.2;
    }
}
