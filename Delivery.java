public class Delivery {
    
    private int arrivalHour;
    public int getArrivalHour() {
        return arrivalHour;
    }

    private String partType;
    public String getPartType() {
        return partType;
    }

    private int size;
    public int getSize() {
        return size;
    }

    public Delivery(int arrivalHour, String partType, int size) {
        this.arrivalHour = arrivalHour;
        this.partType = partType;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Delivery [arrivalHour=" + arrivalHour + ", partType=" + partType + ", size=" + size + "]";
    }

}
