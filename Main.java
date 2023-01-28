import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ToyFactory tf = new ToyFactory();

        ComponentManufacturer furManufacturer = new ComponentManufacturer(Config.FUR_PRODUCTION_RATE, Config.FUR_PACKAGE_SIZE, Config.FUR_TRAVEL_TIME_HOURS, PartType.FUR);
        ComponentManufacturer fillingManufacturer = new ComponentManufacturer(Config.FILLING_PRODUCTION_RATE, Config.FILLING_PACKAGE_SIZE, Config.FILLING_TRAVEL_TIME_HOURS, PartType.FILLING);
        ComponentManufacturer noseManufacturer = new ComponentManufacturer(Config.NOSE_PRODUCTION_RATE, Config.NOSE_PACKAGE_SIZE, Config.NOSE_TRAVEL_TIME_HOURS, PartType.NOSE);
        ComponentManufacturer eyeManufacturer = new ComponentManufacturer(Config.EYE_PRODUCTION_RATE, Config.EYE_PACKAGE_SIZE, Config.EYE_TRAVEL_TIME_HOURS, PartType.EYE);

        List<ComponentManufacturer> manufacturers = new ArrayList<ComponentManufacturer>();

        manufacturers.add(furManufacturer);
        manufacturers.add(fillingManufacturer);
        manufacturers.add(noseManufacturer);
        manufacturers.add(eyeManufacturer);

        List<Delivery> deliveries = new ArrayList<Delivery>();

        int simulationHoursPassed = 0;
        int fixSabotageHour = 0;
        LocalDateTime simulationDate = Config.SIMULATION_BEGINNING;
        double efficienciesSum = 0;

        // main simulation loop
        while (tf.getToysFinished() < Config.TOY_TOTAL_PRODUCTION_TARGET) {

            if (Config.VERBOSE) {
                System.out.println("simulation hours passed: " + simulationHoursPassed);
                System.out.println(tf.toString());
                for (Delivery d : deliveries) {
                    System.out.println(d);
                }
                System.out.println("---------" + "\n");
            }

            if (simulationHoursPassed >= Config.SIMULATION_HOURS_CAP && Config.SIMULATION_HOURS_CAP != -1) {
                break;
            }

            simulationHoursPassed++;
            simulationDate = simulationDate.plusHours(1);

            efficienciesSum += tf.makeToys();

            if (simulationHoursPassed == fixSabotageHour) {
                noseManufacturer.setSabotaged(false);
            }

            // sabotage is attempted once a week and has a 10% chance of success
            if (simulationDate.getDayOfWeek() == DayOfWeek.MONDAY && simulationDate.getHour() == 0) {
                if (Math.random() > 0.9) {
                    noseManufacturer.setSabotaged(true);
                    fixSabotageHour = simulationHoursPassed + 12;
                }
            }

            for (ComponentManufacturer cm : manufacturers) {
                int packages = cm.makeComponents();
                    for (int i = 0; i < packages; i++) {
                        // in December, deliveries take twice as long and have a 20% chance of failing
                        if (simulationDate.getMonth() == Month.DECEMBER) {
                            if (Math.random() > 0.2) {
                                deliveries.add(new Delivery(simulationHoursPassed + cm.getTravelTimeHours() * 2, cm.getPart(), cm.getPackageSize()));
                            }
                        }
                        else {
                            deliveries.add(new Delivery(simulationHoursPassed + cm.getTravelTimeHours(), cm.getPart(), cm.getPackageSize()));
                        }
                    }
            }

            // use an iterator so we can safely delete deliveries while looping through them
            Iterator<Delivery> i = deliveries.iterator();
            while (i.hasNext()) {
                Delivery d = i.next();
                if (simulationHoursPassed == d.getArrivalHour()) {
                    tf.receiveDelivery(d);
                    i.remove();
                }
            }

        }

        System.out.println("Simulation finished!");
        System.out.println("Simulation started at " + Config.SIMULATION_BEGINNING + " and ended at " + simulationDate);
        System.out.println("Hours passed: " + simulationHoursPassed);
        System.out.println("Toys produced: " + tf.getToysFinished());
        System.out.println("Average efficiency: " + efficienciesSum / simulationHoursPassed);

    }
    
}
