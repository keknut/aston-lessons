package App;
import chainOfResponsibility.*;

public class Chain {
    public static void main(String[] args) {
        Handler handler1 = new FirstHandler();
        Handler handler2 = new SecondHandler();
        Handler handler3 = new ThirdHandler();

        handler1.setNext(handler2);
        handler2.setNext(handler3);

        Request hand1 = new Request(1);
        Request hand2 = new Request(2);
        Request hand3 = new Request(3);
        Request hand4 = new Request(4);

        System.out.println("=== Обработка запроса 1 ===");
        handler1.handle(hand1);

        System.out.println("\n=== Обработка запроса 2 ===");
        handler1.handle(hand2);

        System.out.println("\n=== Обработка запроса 3 ===");
        handler1.handle(hand3);

        System.out.println("\n=== Обработка запроса 4 ===");
        handler1.handle(hand4);
    }
}
