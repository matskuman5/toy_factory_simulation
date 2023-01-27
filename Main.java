import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ToyFactory tf = new ToyFactory();

        ComponentManufacturer furManufacturer = new ComponentManufacturer(Config.FUR_PRODUCTION_RATE, Config.FUR_PACKAGE_SIZE, Config.FUR_TRAVEL_TIME_HOURS);
        ComponentManufacturer fillingManufacturer = new ComponentManufacturer(Config.FILLING_PRODUCTION_RATE, Config.FILLING_PACKAGE_SIZE, Config.FILLING_TRAVEL_TIME_HOURS);
        ComponentManufacturer noseManufacturer = new ComponentManufacturer(Config.NOSE_PRODUCTION_RATE, Config.NOSE_PACKAGE_SIZE, Config.NOSE_TRAVEL_TIME_HOURS);
        ComponentManufacturer eyeManufacturer = new ComponentManufacturer(Config.EYE_PRODUCTION_RATE, Config.EYE_PACKAGE_SIZE, Config.EYE_TRAVEL_TIME_HOURS);

        ArrayList<ComponentManufacturer> manufacturers = new ArrayList<ComponentManufacturer>();

        manufacturers.add(furManufacturer);
        manufacturers.add(fillingManufacturer);
        manufacturers.add(noseManufacturer);
        manufacturers.add(eyeManufacturer);

        int simulationHour = 0;

        while (tf.getToysFinished() < Config.TOY_TOTAL_PRODUCTION) {

            simulationHour++;

            for (ComponentManufacturer cm : manufacturers) {
                cm.stock += cm.getComponentsPerHour();
                if (cm.stock >= cm.getPackageSize()) {
                    cm.stock = 0;
                    // TODO: send delivery
                }
            }

            tf.makeToys();

            System.out.println("simulation hour: " + simulationHour);
            System.out.println(tf.toString());
            System.out.println("---------" + "\n");
        }

    }
    
}
