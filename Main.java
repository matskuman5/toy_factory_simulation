import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        ToyFactory tf = new ToyFactory();

        ComponentManufacturer furManufacturer = new ComponentManufacturer(Config.FUR_PRODUCTION_RATE, Config.FUR_PACKAGE_SIZE, Config.FUR_TRAVEL_TIME_HOURS, "furs");
        ComponentManufacturer fillingManufacturer = new ComponentManufacturer(Config.FILLING_PRODUCTION_RATE, Config.FILLING_PACKAGE_SIZE, Config.FILLING_TRAVEL_TIME_HOURS, "fillings");
        ComponentManufacturer noseManufacturer = new ComponentManufacturer(Config.NOSE_PRODUCTION_RATE, Config.NOSE_PACKAGE_SIZE, Config.NOSE_TRAVEL_TIME_HOURS, "noses");
        ComponentManufacturer eyeManufacturer = new ComponentManufacturer(Config.EYE_PRODUCTION_RATE, Config.EYE_PACKAGE_SIZE, Config.EYE_TRAVEL_TIME_HOURS, "eyes");

        ArrayList<ComponentManufacturer> manufacturers = new ArrayList<ComponentManufacturer>();

        manufacturers.add(furManufacturer);
        manufacturers.add(fillingManufacturer);
        manufacturers.add(noseManufacturer);
        manufacturers.add(eyeManufacturer);

        ArrayList<Delivery> deliveries = new ArrayList<Delivery>();

        int simulationHour = 0;

        while (tf.getToysFinished() < Config.TOY_TOTAL_PRODUCTION) {

            if (Config.VERBOSE) {
                System.out.println("simulation hours passed: " + simulationHour);
                System.out.println(tf.toString());
                for (Delivery d : deliveries) {
                    System.out.println(d);
                }
                System.out.println("---------" + "\n");
            }

            if (simulationHour >= Config.SIMULATION_HOURS_CAP && Config.SIMULATION_HOURS_CAP != -1) {
                break;
            }

            simulationHour++;

            tf.makeToys();

            for (ComponentManufacturer cm : manufacturers) {
                if (cm.makeComponents()) {
                    deliveries.add(new Delivery(simulationHour + cm.getTravelTimeHours(), cm.getPartType(), cm.getPackageSize()));
                }
            }

            Iterator<Delivery> i = deliveries.iterator();

            while (i.hasNext()) {
                Delivery d = i.next();
                if (simulationHour == d.getArrivalHour()) {
                    tf.receiveDelivery(d);
                    i.remove();
                }
            }

        }

        System.out.println("Simulation finished!");
        System.out.println("Hours passed: " + simulationHour);
        System.out.println("Toys produced: " + tf.getToysFinished());

    }
    
}
