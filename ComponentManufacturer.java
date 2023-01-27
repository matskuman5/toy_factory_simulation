public class ComponentManufacturer {

    private int stock = 0;
    private String partType;

    public String getPartType() {
        return partType;
    }

    private int componentsPerHour;
    public int getComponentsPerHour() {
        return componentsPerHour;
    }

    private int packageSize;
    public int getPackageSize() {
        return packageSize;
    }

    private int travelTimeHours;
    public int getTravelTimeHours() {
        return travelTimeHours;
    }

    public boolean makeComponents() {
        stock += componentsPerHour;
        if (stock >= packageSize) {
            stock -= packageSize;
            return true;
        }
        return false;
    }

    public ComponentManufacturer(int componentsPerHour, int packageSize, int travelTimeHours, String partType) {
        this.componentsPerHour = componentsPerHour;
        this.packageSize = packageSize;
        this.travelTimeHours = travelTimeHours;
        this.partType = partType;
    }

}