public class Main {
    public static void main(String[] args) {
        ToyFactory tf = new ToyFactory();

        int simulationHour = 0;

        while (tf.getToysFinished() < Config.TOY_TOTAL_PRODUCTION) {

            simulationHour++;

            System.out.println("simulation hour: " + simulationHour);
            System.out.println(tf.toString());
            System.out.println("---------" + "\n");
        }

    }
    
}
