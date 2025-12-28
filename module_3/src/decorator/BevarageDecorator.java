package decorator;

public abstract class BevarageDecorator implements Bevarage{
    protected Bevarage bevarage;

    public BevarageDecorator(Bevarage bevarage) {
        this.bevarage = bevarage;
    }

}
