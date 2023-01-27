import java.util.HashMap;

public class ToyFactory {

    private HashMap<String, Integer> stock = new HashMap<String, Integer>();

    private int toysFinished = 0;

    public int getToysFinished() {
        return toysFinished;
    }

    public void makeToys() {

        // find what parts we have the least of
        int least = -1;
        for (Integer amount : stock.values()) {
            if (least == -1) least = amount;
            else if (least > amount) least = amount;
        }

        // cap production rate at a fixed amount per hour
        if (least > Config.TOY_PRODUCTION_RATE) {
            least = Config.TOY_PRODUCTION_RATE;
        }

        // then reduce our stocks and add finished toys accordingly
        for (String part : stock.keySet()) {
            stock.put(part, stock.get(part) - least);
        }
        toysFinished += least;
    }

    public ToyFactory() {
        stock.put("furs", 1000);
        stock.put("fillings", 1000);
        stock.put("noses", 1000);
        stock.put("eyes", 1000);
    }

    @Override
    public String toString() {
        String s = "";
        for (String part : stock.keySet()) {
            s += part + ", amount: " + stock.get(part) + "\n";
        }
        s += "\n" + "toys finished: " + toysFinished;
        return s;
    }

}