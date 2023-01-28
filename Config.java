import java.time.LocalDateTime;

public final class Config {
    public static final int FUR_PRODUCTION_RATE = 40;
    public static final int FUR_PACKAGE_SIZE = 200;
    public static final int FUR_TRAVEL_TIME_HOURS = 10;
    
    public static final int FILLING_PRODUCTION_RATE = 45;
    public static final int FILLING_PACKAGE_SIZE = 10;
    public static final int FILLING_TRAVEL_TIME_HOURS = 12;
    
    public static final int NOSE_PRODUCTION_RATE = 60;
    public static final int NOSE_PACKAGE_SIZE = 100;
    public static final int NOSE_TRAVEL_TIME_HOURS = 8;
    
    public static final int EYE_PRODUCTION_RATE = 90;
    public static final int EYE_PACKAGE_SIZE = 300;
    public static final int EYE_TRAVEL_TIME_HOURS = 14;

    public static final int TOY_PRODUCTION_RATE = 500;
    public static final int TOY_TOTAL_PRODUCTION_TARGET = 1000000;

    public static final int SIMULATION_HOURS_CAP = -1; // -1 = not capped
    public static final LocalDateTime SIMULATION_BEGINNING = LocalDateTime.of(2023, 4, 1, 0, 0);

    public static final boolean VERBOSE = false;
}