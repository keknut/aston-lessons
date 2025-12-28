package builder;

public class Computer {
    private String motherboard;
    private String processor;
    private String ram;
    private String ssd;
    private String gpu;
    private boolean hasWifi;

    public String getMotherboard() { return motherboard; }
    public String getProcessor() { return processor; }
    public String getRam() { return ram; }
    public String getSsd() { return ssd; }
    public String getGpu() { return gpu; }
    public boolean hasWifi() { return hasWifi; }

    public void setMotherboard(String motherboard) { this.motherboard = motherboard; }
    public void setProcessor(String processor) { this.processor = processor; }
    public void setRam(String ram) { this.ram = ram; }
    public void setSsd(String ssd) { this.ssd = ssd; }
    public void setGpu(String gpu) { this.gpu = gpu; }
    public void setHasWifi(boolean hasWifi) { this.hasWifi = hasWifi; }

    @Override
    public String toString() {
            return "Conputer{" +
                    "motherboard='" + motherboard + '\'' + 
                    ", processor='" + processor + '\'' + 
                    ", ram='" + ram + '\'' + 
                    ", ssd='" + ssd + '\'' + 
                    ", gpu='" + gpu + '\'' + 
                    ", hasWifi=" + hasWifi + '}';
    }
}