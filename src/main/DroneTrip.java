package main;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rajbir on 9/5/15.
 */
public class DroneTrip {
    private Drone drone;
    private List<DeliveryLocation> deliveryLocations;

    public DroneTrip(Drone drone, List<DeliveryLocation> deliveryLocations) {
        this.drone = drone;
        this.deliveryLocations = deliveryLocations;
    }

    public Drone getDrone() {
        return drone;
    }

    public void setDrone(Drone drone) {
        this.drone = drone;
    }

    public List<DeliveryLocation> getDeliveryLocations() {
        return deliveryLocations;
    }

    public void setDeliveryLocations(List<DeliveryLocation> deliveryLocations) {
        this.deliveryLocations = deliveryLocations;
    }

    public List<Integer> getDeliveryWeights(){
        ArrayList<Integer> deliveryWeights = new ArrayList<Integer>();
        for (DeliveryLocation deliveryLocation : deliveryLocations) {
            deliveryWeights.add(deliveryLocation.getDeliveryWeight());
        }
        return deliveryWeights;
    }
}
