import java.util.HashMap;

public class ToyFactory {

    private HashMap<PartType, Integer> stock = new HashMap<PartType, Integer>();

    private int toysFinished = 0;

    public int getToysFinished() {
        return toysFinished;
    }

    public void receiveDelivery(Delivery d) {
        stock.put(d.getPartType(), stock.get(d.getPartType()) + d.getSize());
    }

    public double makeToys() {

        // find what parts we have the least of
        int least = -1;
        for (PartType part : stock.keySet()) {
            int amount = stock.get(part);
            if (part == PartType.EYE) {
                amount = amount / 2;
            }
            if (least == -1) least = amount;
            else if (least > amount) least = amount;
        }

        // cap production rate at a fixed amount per hour
        if (least > Config.TOY_PRODUCTION_RATE) {
            least = Config.TOY_PRODUCTION_RATE;
        }

        // then reduce our stocks and add finished toys accordingly
        for (PartType part : stock.keySet()) {
            stock.put(part, stock.get(part) - least);
        }
        toysFinished += least;

        // return what percentage of max production rate is actually achieved
        return ((double) least) / Config.TOY_PRODUCTION_RATE;

    }

    public ToyFactory() {
        stock.put(PartType.FUR, 0);
        stock.put(PartType.FILLING, 0);
        stock.put(PartType.NOSE, 0);
        stock.put(PartType.EYE, 0);
    }

    @Override
    public String toString() {
        String s = "";
        for (PartType part : stock.keySet()) {
            s += part + ", amount: " + stock.get(part) + "\n";
        }
        s += "\n" + "toys finished: " + toysFinished;
        return s;
    }

}