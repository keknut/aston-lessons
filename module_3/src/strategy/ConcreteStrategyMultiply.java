package strategy;

public class ConcreteStrategyMultiply implements Strategy {
    @Override
    public int execute(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        } else {
            return a * b;
        }
    }
}
