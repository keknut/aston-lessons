package App;
import builder.*;

public class Build {
    public static void main(String[] args) {
        Director director = new Director();

        Builder officeBuilder = new OfficeComputerBuilder();
        Computer offiComputer = director.construct(officeBuilder);
        System.out.println("Office computer:");
        System.out.println(offiComputer);
    }
}
