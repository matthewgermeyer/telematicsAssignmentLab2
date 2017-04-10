import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        TelematicsImpl telematics = new TelematicsImpl();

        VehicleInfo vehicleInfo = new VehicleInfo();
        vehicleInfo.setEngineSize("3");
        vehicleInfo.setGasUsed(14.2);
        vehicleInfo.setLastOilChange(44);
        vehicleInfo.setOdometer(46.5);
        vehicleInfo.setVin("001");
        //CALL REPORT VIN001
        telematics.report(vehicleInfo);

        //new vin

        vehicleInfo = new VehicleInfo();
        vehicleInfo.setVin("002");
        vehicleInfo.setEngineSize("3.2");
        vehicleInfo.setGasUsed(20);
        vehicleInfo.setLastOilChange(28);
        vehicleInfo.setOdometer(38);
        //CALL REPORT VIN 002
        telematics.report(vehicleInfo);

    }
}

