package LAB3_Week03.Ex5;

public class Shampoo extends Product {
    public static final String DRY = "Dry Hair Shampoo";
    public static final String OILY_1 = "Oily Hair Shampoo - Standard 1";
    public static final String OILY_2 = "Oily Hair Shampoo - Standard 2";

    public static final long DRY_RATE = 20_000L;
    public static final long OILY_1_RATE = 30_000L;
    public static final long OILY_2_RATE = 40_000L;

    public Shampoo(String id, String type, int volume) {
        super(id, type, volume, getRate(type));
    }

    private static long getRate(String type) {

        if (DRY.equals(type)) {
            return DRY_RATE;
        }

        if (OILY_1.equals(type)) {
            return OILY_1_RATE;
        }

        if (OILY_2.equals(type)) {
            return OILY_2_RATE;
        }

        throw new IllegalArgumentException("Invalid shampoo type.");
    }

    public boolean isOilyHairShampoo() {
        return OILY_1.equals(getType()) || OILY_2.equals(getType());
    }
}
