import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.Arrays;

public class TelematicsImpl implements Telematics {

    // here is where the array instance variable should be declared
    VehicleInfo list[] = new VehicleInfo[10];

    @Override
    public void report(VehicleInfo vehicleInfo) throws IOException {
        //Json
        System.out.println("vehicleInfo before " + vehicleInfo);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(vehicleInfo);
        System.out.println("json for 'vehicle info' : " + json);

        //VehicleInfo vehicleInfo2 = mapper.readValue(json, VehicleInfo.class);
        //System.out.println("vehicleInfo2 is " + vehicleInfo2);
        //write json into -> file VIN.json

        PrintWriter out = new PrintWriter((new FileWriter(vehicleInfo.getVin() + ".json")));
        out.println(json);
        out.flush();
        //TODO: move this into a try with resource.
        out.close();

        //read all json files
        File file = new File(".");
        int count = 0;
        int fixes = 0;
//        int count2 = 0;
//        int count3 = 0;
//        int count4 = 0;   //dont know that I need these... but it made sense ..
        for (File f : file.listFiles()) {
            if (f.getName().endsWith(".json")) {

                //Read json from file
                BufferedReader in = new BufferedReader(new FileReader(f.getName()));
                String jsonFromFile = in.readLine();

                //turn json back into Vehicleinfo
                VehicleInfo vIRessurected = mapper.readValue(jsonFromFile, VehicleInfo.class);
                System.out.println("vIRessurected is " + vIRessurected);

                // put it into an array.
                list[count] = vIRessurected;
                ++count;
                ++fixes;

            }
        }//end For
        System.out.println(Arrays.toString(list));
        int avg_miles = ((111 + 123) / (count));

        String temp = Telematics.HTML.replace("num_vehicles", "" + count);

        PrintWriter tempWriter = new PrintWriter((new FileWriter("Dashboard.html")));
        tempWriter.println(temp);
        tempWriter.flush();
        tempWriter.close();

        String temp1 = Telematics.HTML.replace("num_vehicles", "" + count);
        PrintWriter tempWriter1 = new PrintWriter(new FileWriter("Dashboard.html"));

        tempWriter1.println(temp1);
        tempWriter1.flush();
        tempWriter1.close();


//        String temp2 = temp1;
//        String temp3 = Telematics.HTML.replace("avg_miles", "" + avg_miles);
//        PrintWriter tempWriter2= new PrintWriter((new FileWriter("Dashboard.html")));

//        tempWriter2.println(temp);
//        tempWriter2.flush();
//        tempWriter2.close();

        System.out.println(temp1);

//        String temp2 = Telematics.HTML.replace("consumption_avg", "" + ((222.2+123)/2));
//
//        PrintWriter tempWriter2 = new PrintWriter((new FileWriter("Dashboard.html")));
//        tempWriter2.println(temp1);
//        tempWriter2.flush();
//        tempWriter2.close();

        /*   -- What a rewrite looks like --

        String temp = Telematics.HTML.replace("num_vehicles", "" + count);

        PrintWriter tempWriter = new PrintWriter((new FileWriter("Dashboard.html")));
        tempWriter.println(temp);
        tempWriter.flush();
        tempWriter.close();

*/
        //Things to replace
//
//                consumption_avg
//                  last_oil_change
//                Engine_size
    }

    static void logException(Throwable e) {
        System.out.println(e.getMessage());
    }
}

