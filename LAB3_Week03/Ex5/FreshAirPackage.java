package LAB3_Week03.Ex5;

public class FreshAirPackage extends CosmeticPackage {
    public FreshAirPackage(Shampoo oilyHairShampoo,
                           Perfume optionalPerfume,
                           ShowerGel optionalShowerGel) {

        super("Fresh-Air Package");

        if (oilyHairShampoo == null
                || !oilyHairShampoo.isOilyHairShampoo()) {

            throw new IllegalArgumentException(
                "Fresh-Air Package must include Oily Hair Shampoo."
            );
        }

        addProduct(oilyHairShampoo);
        addProduct(optionalPerfume);
        addProduct(optionalShowerGel);
    }
}
