public class ComponentManufacturer {

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

    public ComponentManufacturer(int componentsPerHour, int packageSize, int travelTimeHours) {
        this.componentsPerHour = componentsPerHour;
        this.packageSize = packageSize;
        this.travelTimeHours = travelTimeHours;
    }

}