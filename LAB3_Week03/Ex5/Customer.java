package LAB3_Week03.Ex5;

public class Customer {
    private final String customerId;
    private String fullName;
    private String address;
    private String phoneNumber;

    public Customer(String customerId, String fullName,
                    String address, String phoneNumber) {

        this.customerId = requireNonBlank(customerId, "Customer ID");
        setFullName(fullName);
        setAddress(address);
        setPhoneNumber(phoneNumber);
    }

    private static String requireNonBlank(
            String value, String fieldName) {

        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(
                fieldName + " cannot be empty."
            );
        }

        return value.trim();
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setFullName(String fullName) {
        this.fullName = requireNonBlank(fullName, "Full name");
    }

    public void setAddress(String address) {
        this.address = requireNonBlank(address, "Address");
    }

    public void setPhoneNumber(String phoneNumber) {

        String phone = requireNonBlank(phoneNumber, "Phone number");

        if (!phone.matches("\\d{9,11}")) {
            throw new IllegalArgumentException(
                "Phone number must contain 9 to 11 digits."
            );
        }

        this.phoneNumber = phone;
    }

    @Override
    public String toString() {
        return String.format(
            "Customer ID: %s | Name: %s | Address: %s | Phone: %s",
            customerId, fullName, address, phoneNumber
        );
    }
}
