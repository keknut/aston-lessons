package strategy;

public interface Strategy {
    int execute(int a, int b);

    default void info(){
        System.out.println("Выберите операцию");
    }
}