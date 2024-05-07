package Models;

public class Ticket {
    
    private String id;
    private Slot slot;
    private Vehicle vehicle;
    private Boolean hasExpired;

    public Ticket(String id, Slot slot, Vehicle vehicle) {
        this.id = id;
        this.slot = slot;
        this.vehicle = vehicle;
        this.hasExpired = false;
    }

    public String getId() {
        return id;
    }

    public Slot getSlot() {
        return slot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Boolean getHasExpired() {
        return hasExpired;
    }

    public void setHasExpired(Boolean hasExpired) {
        this.hasExpired = hasExpired;
    }

}
