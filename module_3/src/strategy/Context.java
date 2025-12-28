package strategy;

public class Context {
    Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int a, int b) {
        if (strategy != null) {
            return strategy.execute(a, b);
        } else {
            throw new IllegalStateException("Strategy not set");
        }
    }
}
