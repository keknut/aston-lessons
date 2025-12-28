package builder;

public class Director {
    public Computer construct(Builder builder) {
        builder.buildMotherboard();
        builder.buildProcessor();
        builder.buildRam();
        builder.buildSsd();
        builder.buildGpu();
        builder.buildWifi();
        return builder.getComputer();
    }
}
