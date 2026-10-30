package LAB3_Week03.Ex5;

public class ShowerGel extends Product {
    public static final String DRY_SKIN = "Dry Skin Shower Gel";
    public static final String OILY_SKIN = "Oily Skin Shower Gel";

    public static final long DRY_RATE = 20_000L;
    public static final long OILY_RATE = 40_000L;

    public ShowerGel(String id, String type, int volume) {
        super(id, type, volume, getRate(type));
    }

    private static long getRate(String type) {

        if (DRY_SKIN.equals(type)) {
            return DRY_RATE;
        }

        if (OILY_SKIN.equals(type)) {
            return OILY_RATE;
        }

        throw new IllegalArgumentException("Invalid shower gel type.");
    }
}
