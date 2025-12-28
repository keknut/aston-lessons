package builder;

public class OfficeComputerBuilder implements Builder {
    private Computer computer;

    public OfficeComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildMotherboard() {
        computer.setMotherboard("ASUS ROG Strix");
    }

    @Override
    public void buildProcessor() {
        computer.setProcessor("Intel Core i9-13900HX");
    }

    @Override
    public void buildRam() {
        computer.setRam("32 GB");
    }

    @Override
    public void buildSsd() {
        computer.setSsd("1 TB");
    }

    @Override
    public void buildGpu() {
        computer.setGpu("NVIDIA GeForce RTX 4090");
    }

    @Override
    public void buildWifi() {
        computer.setHasWifi(true);
    }

    @Override
    public Computer getComputer() {
        return computer;
    }

}
