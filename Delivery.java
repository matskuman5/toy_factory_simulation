public class Delivery {
    
    private int arrivalHour;
    public int getArrivalHour() {
        return arrivalHour;
    }

    private PartType part;
    public PartType getPartType() {
        return part;
    }

    private int size;
    public int getSize() {
        return size;
    }

    public Delivery(int arrivalHour, PartType part, int size) {
        this.arrivalHour = arrivalHour;
        this.part = part;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Delivery [arrivalHour=" + arrivalHour + ", part=" + part + ", size=" + size + "]";
    }

}
