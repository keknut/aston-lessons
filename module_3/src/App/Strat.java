package App;
import strategy.*;

public class Strat {
    public static void main(String[] args) throws Exception {
        int a = 1;
        int b = 4;
        char action = '+';

        Context context = new Context();

        if(action == '+'){
            context.setStrategy(new ConcreteStrategyAdd());
        }

        if(action == '-'){
            context.setStrategy(new ConcreteStrategySubtract());
        }

        if(action == '*'){
            context.setStrategy(new ConcreteStrategyMultiply());
        }

        int result = context.executeStrategy(a, b);

        System.out.println("result: " + result);
    }
}