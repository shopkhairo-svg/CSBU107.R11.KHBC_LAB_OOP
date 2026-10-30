package LAB3_Week03.Ex3;

import java.util.ArrayList;
import java.util.List;

public class Room {
    public static final long VIP1_PRICE = 900_000L;
    public static final long VIP2_PRICE = 700_000L;
    public static final long VIP3_PRICE = 500_000L;

    private String roomType;
    private int rentalDays;

    private final List<Guest> guests;

    // Constructor
    public Room(String roomType, int rentalDays) {

        this.guests = new ArrayList<>();

        setRoomType(roomType);
        setRentalDays(rentalDays);
    }

    // Getters
    public String getRoomType() {
        return roomType;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public List<Guest> getGuests() {
        return new ArrayList<>(guests);
    }

    // Setters
    public void setRoomType(String roomType) {

        if (roomType == null) {
            throw new IllegalArgumentException(
                "Room type cannot be null."
            );
        }

        String type = roomType.trim().toUpperCase();

        if (!type.equals("VIP1")
                && !type.equals("VIP2")
                && !type.equals("VIP3")) {

            throw new IllegalArgumentException(
                "Room type must be VIP1, VIP2 or VIP3."
            );
        }

        this.roomType = type;
    }

    public void setRentalDays(int rentalDays) {

        if (rentalDays <= 0) {
            throw new IllegalArgumentException(
                "Rental days must be greater than 0."
            );
        }

        this.rentalDays = rentalDays;
    }

    // Get daily room price
    public long getDailyPrice() {

        switch (roomType) {
            case "VIP1":
                return VIP1_PRICE;

            case "VIP2":
                return VIP2_PRICE;

            case "VIP3":
                return VIP3_PRICE;

            default:
                throw new IllegalStateException(
                    "Invalid room type."
                );
        }
    }

    // Calculate rental cost
    public long calculateRentalCost() {
        return getDailyPrice() * rentalDays;
    }

    // Add guest to room
    public void addGuest(Guest guest) {

        if (guest == null) {
            throw new IllegalArgumentException(
                "Guest cannot be null."
            );
        }

        for (Guest currentGuest : guests) {
            if (currentGuest.getCitizenId().equals(
                    guest.getCitizenId())) {

                throw new IllegalArgumentException(
                    "Guest already exists in this room."
                );
            }
        }

        guests.add(guest);
    }

    // Remove guest by Citizen ID
    public boolean removeGuest(String citizenId) {

        if (citizenId == null) {
            return false;
        }

        String id = citizenId.trim();

        return guests.removeIf(
            guest -> guest.getCitizenId().equals(id)
        );
    }

    // Display guests
    public void displayGuests() {

        if (guests.isEmpty()) {
            System.out.println("No guests in this room.");
            return;
        }

        for (Guest guest : guests) {
            System.out.println(guest);
        }
    }

    @Override
    public String toString() {
        return String.format(
            "Room: %s | Daily Price: %,d VND | Days: %d | Total: %,d VND",
            roomType,
            getDailyPrice(),
            rentalDays,
            calculateRentalCost()
        );
    }
}
