public class Floor {
    
    private Integer floorNumber;
    private Integer slots;

    Floor(Integer floorNumber, Integer slots){
        this.slots = slots;
        this.floorNumber = floorNumber;
    }

    public void addSlots(Integer additionalSlots){
        this.slots += additionalSlots;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public Integer getSlots() {
        return slots;
    }
    
}
