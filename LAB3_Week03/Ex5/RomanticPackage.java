package LAB3_Week03.Ex5;

public class RomanticPackage extends CosmeticPackage {
    public RomanticPackage(Perfume rosePerfume,
                           Shampoo optionalShampoo,
                           ShowerGel optionalShowerGel) {

        super("Romantic Package");

        // Validate mandatory Rose Perfume
        if (rosePerfume == null
                || !Perfume.ROSE.equals(rosePerfume.getType())) {

            throw new IllegalArgumentException(
                "Romantic Package must include Rose Perfume."
            );
        }

        addProduct(rosePerfume);
        addProduct(optionalShampoo);
        addProduct(optionalShowerGel);
    }
}
