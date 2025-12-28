package builder;

public interface Builder {
    void buildMotherboard();
    void buildProcessor();
    void buildRam();
    void buildSsd();
    void buildGpu();
    void buildWifi();

    Computer getComputer();
    
}
