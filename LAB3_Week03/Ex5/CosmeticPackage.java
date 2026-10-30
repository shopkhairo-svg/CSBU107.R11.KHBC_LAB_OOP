package LAB3_Week03.Ex5;

import java.util.ArrayList;
import java.util.List;

public abstract class CosmeticPackage {
    private final String packageName;
    private final List<Product> products;

    public CosmeticPackage(String packageName) {
        this.packageName = packageName;
        this.products = new ArrayList<>();
    }

    // Used by subclasses when constructing a package
    protected void addProduct(Product product) {

        if (product == null) {
            return;
        }

        for (Product existing : products) {
            if (existing.getProductId().equals(product.getProductId())) {
                throw new IllegalArgumentException(
                    "Duplicate product ID in package."
                );
            }
        }

        products.add(product);
    }

    public String getPackageName() {
        return packageName;
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    // Calculate total package price
    public long calculatePackagePrice() {

        long total = 0;

        for (Product product : products) {
            total = Math.addExact(total, product.getPrice());
        }

        return total;
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();

        result.append("Package: ")
              .append(packageName)
              .append("\n");

        for (Product product : products) {
            result.append("  ")
                  .append(product)
                  .append("\n");
        }

        result.append(
            String.format("Package Total: %,d VND", calculatePackagePrice())
        );

        return result.toString();
    }
}
