public class ComponentManufacturer {

    private int stock = 0;
    
    private boolean sabotaged = false;

    public void setSabotaged(boolean sabotaged) {
        this.sabotaged = sabotaged;
    }

    private PartType part;
    public PartType getPart() {
        return part;
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

    public int makeComponents() {
        if (sabotaged) {
            return 0;
        }
        stock += componentsPerHour;
        if (stock >= packageSize) {
            int packages = stock / packageSize;
            stock -= packages * packageSize;
            return packages;
        }
        return 0;
    }

    public ComponentManufacturer(int componentsPerHour, int packageSize, int travelTimeHours, PartType part) {
        this.componentsPerHour = componentsPerHour;
        this.packageSize = packageSize;
        this.travelTimeHours = travelTimeHours;
        this.part = part;
    }

}