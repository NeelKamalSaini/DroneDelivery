package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Created by Rajbir on 9/4/15.
 */
public class DroneDeliveryService {

    public List<DroneTrip> findMostEfficientTripsNew(DroneTrip droneTripWithAllLocations) {
        ArrayList<DroneTrip> droneTrips = new ArrayList<DroneTrip>();
        List<DeliveryLocation> allDeliveryLocations = droneTripWithAllLocations.getDeliveryLocations();
        Integer droneCapacity = droneTripWithAllLocations.getDrone().getCapacity();
        String droneName = droneTripWithAllLocations.getDrone().getName();
        Collections.sort(allDeliveryLocations);
        int currSum = 0;
        int start = 0;
        for (int i = 0; i <= allDeliveryLocations.size(); i++) {
            if (currSum > droneCapacity) {
                ArrayList<DeliveryLocation> mostEfficientLocations = new ArrayList<DeliveryLocation>();
                for (int j = start; j < i - 1; j++) {
                    mostEfficientLocations.add(allDeliveryLocations.get(j));
                }
                DroneTrip droneTrip = new DroneTrip(new Drone(droneName, droneCapacity), mostEfficientLocations);
                droneTrips.add(droneTrip);
                start = i - 1;
                currSum = allDeliveryLocations.get(i - 1).getDeliveryWeight();
            }
            if (i < allDeliveryLocations.size()) {
                currSum = currSum + allDeliveryLocations.get(i).getDeliveryWeight();
            }
            if (i == allDeliveryLocations.size()) {
                DroneTrip droneTrip = new DroneTrip(new Drone(droneName, droneCapacity), Arrays.asList(allDeliveryLocations.get(i - 1)));
                droneTrips.add(droneTrip);
            }
        }
        return droneTrips;
    }

    public Drone extractDroneFromInput(String inputString) {
        String[] allLines = inputString.split("\n");
        String[] firstLine = allLines[0].split(", ");
        return new Drone(firstLine[0], Integer.parseInt(firstLine[1]));
    }

    public List<DeliveryLocation> extractDeliveryLocationsFromInput(String inputString) {
        ArrayList<DeliveryLocation> deliveryLocations = new ArrayList<DeliveryLocation>();
        String[] allLines = inputString.split("\n");
        for (int i = 1; i < allLines.length; i++) {
            String[] line = allLines[i].split(", ");
            deliveryLocations.add(new DeliveryLocation(line[0], Integer.parseInt(line[1])));
        }
        return deliveryLocations;
    }

    public List<DroneTrip> summarizeMostEfficientTrips(String inputString) {
        return findMostEfficientTripsNew(new DroneTrip(extractDroneFromInput(inputString),extractDeliveryLocationsFromInput(inputString)));
    }
}
