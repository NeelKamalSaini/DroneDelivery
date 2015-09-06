package main;

import java.util.List;

public class DroneTrip {
    private Drone drone;
    private List<DeliveryLocation> deliveryLocations;

    public DroneTrip(Drone drone, List<DeliveryLocation> deliveryLocations) {
        this.drone = drone;
        this.deliveryLocations = deliveryLocations;
    }

    public DroneTrip(Drone drone) {
        this.drone = drone;
    }

    public Drone getDrone() {
        return drone;
    }

    public List<DeliveryLocation> getDeliveryLocations() {
        return deliveryLocations;
    }

    public void setDeliveryLocations(List<DeliveryLocation> deliveryLocations) {
        this.deliveryLocations = deliveryLocations;
    }
}
