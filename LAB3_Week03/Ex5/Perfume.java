package LAB3_Week03.Ex5;

public class Perfume extends Product {
    public static final String ROSE = "Rose Perfume";
    public static final String CHAMOMILE = "Chamomile Perfume";

    public static final long ROSE_RATE = 20_000L;
    public static final long CHAMOMILE_RATE = 15_000L;

    public Perfume(String id, String type, int volume) {
        super(id, type, volume, getRate(type));
    }

    private static long getRate(String type) {

        if (ROSE.equals(type)) {
            return ROSE_RATE;
        }

        if (CHAMOMILE.equals(type)) {
            return CHAMOMILE_RATE;
        }

        throw new IllegalArgumentException("Invalid perfume type.");
    }
}
