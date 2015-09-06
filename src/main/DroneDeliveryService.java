package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DroneDeliveryService {

    public List<DroneTrip> findMostEfficientTrips(DroneTrip tripForAllDeliveries) {
        ArrayList<DroneTrip> droneTrips = new ArrayList<DroneTrip>();
        List<DeliveryLocation> allDeliveryLocations = tripForAllDeliveries.getDeliveryLocations();
        Collections.sort(allDeliveryLocations);
        int currSum = 0;
        int start = 0;
        for (int i = 0; i <= allDeliveryLocations.size(); i++) {
            if (currSum > tripForAllDeliveries.getDrone().getCapacity()) {
                ArrayList<DeliveryLocation> mostEfficientLocations = new ArrayList<DeliveryLocation>();
                for (int j = start; j < i - 1; j++) {
                    mostEfficientLocations.add(allDeliveryLocations.get(j));
                }
                droneTrips.add(createDroneTrip(tripForAllDeliveries, mostEfficientLocations));
                start = i - 1;
                currSum = allDeliveryLocations.get(i - 1).getDeliveryWeight();
            }
            if (i < allDeliveryLocations.size()) {
                currSum = currSum + allDeliveryLocations.get(i).getDeliveryWeight();
            }
            if (i == allDeliveryLocations.size()) {
                droneTrips.add(createDroneTrip(tripForAllDeliveries, Arrays.asList(allDeliveryLocations.get(i - 1))));
            }
        }
        return droneTrips;
    }

    protected Drone extractDroneFromInput(String inputString) {
        String[] allLines = inputString.split("\n");
        String[] firstLine = allLines[0].split(", ");
        return new Drone(firstLine[0], Integer.parseInt(firstLine[1]));
    }

    protected List<DeliveryLocation> extractDeliveryLocationsFromInput(String inputString) {
        ArrayList<DeliveryLocation> deliveryLocations = new ArrayList<DeliveryLocation>();
        String[] allLines = inputString.split("\n");
        for (int i = 1; i < allLines.length; i++) {
            String[] line = allLines[i].split(", ");
            deliveryLocations.add(new DeliveryLocation(line[0], Integer.parseInt(line[1])));
        }
        return deliveryLocations;
    }

    private DroneTrip createDroneTrip(DroneTrip droneTripWithAllLocations, List<DeliveryLocation> mostEfficientLocations) {
        Drone drone = new Drone(droneTripWithAllLocations.getDrone().getName(), droneTripWithAllLocations.getDrone().getCapacity());
        return new DroneTrip(drone, mostEfficientLocations);
    }
}
