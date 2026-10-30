package LAB3_Week03.Ex5;

import java.time.LocalDate;

public class Order {
    private final String orderId;
    private final Customer customer;
    private final LocalDate invoiceDate;
    private final CosmeticPackage productPackage;
    private final long orderPrice;

    public Order(String orderId, Customer customer,
                 LocalDate invoiceDate,
                 CosmeticPackage productPackage) {

        if (orderId == null || orderId.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Order ID cannot be empty."
            );
        }

        if (customer == null || invoiceDate == null
                || productPackage == null) {
            throw new IllegalArgumentException(
                "Customer, invoice date and package are required."
            );
        }

        this.orderId = orderId.trim();
        this.customer = customer;
        this.invoiceDate = invoiceDate;
        this.productPackage = productPackage;
        this.orderPrice = productPackage.calculatePackagePrice();
    }

    public String getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public CosmeticPackage getProductPackage() {
        return productPackage;
    }

    public long getOrderPrice() {
        return orderPrice;
    }

    @Override
    public String toString() {

        return String.format(
            "Order ID: %s%nInvoice Date: %s%n%s%n%s%nORDER TOTAL: %,d VND",
            orderId,
            invoiceDate,
            customer,
            productPackage,
            orderPrice
        );
    }
}
