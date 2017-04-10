public class VehicleInfo {
    public String vin;
    public double odometer;
    public double gasUsed;
    public double lastOilChange;
    public String engineSize;

    //"java bean" = empty constructor
    public VehicleInfo() {
    }

    //GetnSet
    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public double getOdometer() {
        return odometer;
    }

    public void setOdometer(double odometer) {
        this.odometer = odometer;
    }

    public double getGasUsed() {
        return gasUsed;
    }

    public void setGasUsed(double gasUsed) {
        this.gasUsed = gasUsed;
    }

    public double getLastOilChange() {
        return lastOilChange;
    }

    public void setLastOilChange(double lastOilChange) {
        this.lastOilChange = lastOilChange;
    }

    public String getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(String engineSize) {
        this.engineSize = engineSize;
    }

    @Override
    public String toString() {
        return "VehicleInfo{" +
                "vin='" + vin + '\'' +
                ", odometer=" + odometer +
                ", gasUsed=" + gasUsed +
                ", lastOilChange=" + lastOilChange +
                ", engineSize='" + engineSize + '\'' +
                '}';
    }
}
