package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Created by Rajbir on 9/4/15.
 */
public class DroneDeliveryService {
// use haspmap instead of deliveryWeights
    public List<ArrayList<Integer>> findMostEfficientTrips(List<Integer> deliveryWeights, int droneCapacity) throws Exception {
        List<ArrayList<Integer>> arrayLists = new ArrayList<ArrayList<Integer>>();
        int currSum = 0;
        int start = 0;
        Collections.sort(deliveryWeights);
        for (int i = 0; i <= deliveryWeights.size(); i++) {
            if (currSum > droneCapacity) {
                ArrayList<Integer> integersFound = new ArrayList<Integer>();
                for (int j = start; j < i - 1; j++) {
                    if (deliveryWeights.get(j) > droneCapacity) {
                        throw new Exception("Cannot deliver to location #" + deliveryWeights.get(j) + " weight exceeds drone's capacity");
                    }
                    integersFound.add(deliveryWeights.get(j));
                }
                arrayLists.add(integersFound);
                start = i - 1;
                currSum = deliveryWeights.get(i - 1);
            }
            if (i < deliveryWeights.size()) {
                currSum = currSum + deliveryWeights.get(i);
            }
            if (i == deliveryWeights.size()) {
                ArrayList<Integer> integers = new ArrayList<Integer>();
                integers.add(deliveryWeights.get(i - 1));
                arrayLists.add(integers);
            }
        }
        System.out.print(arrayLists.toString());
        return arrayLists;
    }

    public List<DroneTripNew> findMostEfficientTripsNew(List<DeliveryLocation> deliveryLocations, int droneCapacity) throws Exception {
        Collections.sort(deliveryLocations);
        ArrayList<DroneTripNew> droneTripNews = new ArrayList<DroneTripNew>();
        int currSum = 0;
        int start = 0;
        for (int i = 0; i <= deliveryLocations.size(); i++) {
            if (currSum > droneCapacity) {
                DroneTripNew droneTripNew = new DroneTripNew();
                ArrayList<String> locationsFound = new ArrayList<String>();
                for (int j = start; j < i - 1; j++) {
                    if (deliveryLocations.get(j).getDeliveryWeight() > droneCapacity) {
                        throw new Exception("Cannot deliver to location #" + deliveryLocations.get(j).getDeliveryWeight() + " weight exceeds drone's capacity");
                    }
                    locationsFound.add(deliveryLocations.get(j).getName());
                }
                droneTripNew.setLocationNames(locationsFound);
                droneTripNews.add(droneTripNew);
                start = i - 1;
                currSum = deliveryLocations.get(i - 1).getDeliveryWeight();
            }
            if (i < deliveryLocations.size()) {
                currSum = currSum + deliveryLocations.get(i).getDeliveryWeight();
            }
            if (i == deliveryLocations.size()) {
                DroneTripNew droneTripNew = new DroneTripNew();
                ArrayList<String> locationsFound = new ArrayList<String>();
                locationsFound.add(deliveryLocations.get(i - 1).getName());
                droneTripNew.setLocationNames(locationsFound);
                droneTripNews.add(droneTripNew);
            }
        }
        System.out.print(droneTripNews.toString());
        return droneTripNews;
    }

    public Drone extractDroneFromInput(String inputString) {
        String[] allLines = inputString.split("\n");
        String[] firstLine = allLines[0].split(", ");
        return new Drone(firstLine[0],Integer.parseInt(firstLine[1]));
    }

    public List<DeliveryLocation> extractDeliveryLocationsFromInput(String inputString) {
        ArrayList<DeliveryLocation> deliveryLocations = new ArrayList<DeliveryLocation>();
        String[] allLines = inputString.split("\n");
        for (int i = 1; i < allLines.length; i++) {
            String[] line = allLines[i].split(", ");
            deliveryLocations.add(new DeliveryLocation(line[0],Integer.parseInt(line[1])));
        }
        return deliveryLocations;
    }

    public DroneTrip summarizeMostEfficientTrips(String inputString) {

        return null;
    }

    public static void main(String[] args) throws java.lang.Exception {
        ArrayList<DeliveryLocation> deliveryLocations = new ArrayList<DeliveryLocation>();
        deliveryLocations.add(new DeliveryLocation("15", 15));
        deliveryLocations.add(new DeliveryLocation("10", 10));
        deliveryLocations.add(new DeliveryLocation("5", 5));
        int Sum = 15;
        DroneDeliveryService i = new DroneDeliveryService();
        i.findMostEfficientTripsNew(deliveryLocations, Sum);
    }

//    public static void main(String[] args) throws java.lang.Exception {
//        ArrayList<Integer> integers = new ArrayList<Integer>();
//        integers.addAll(Arrays.asList(5, 5, 2, 1));
//        int Sum = 5;
//        DroneDeliveryService i = new DroneDeliveryService();
//        i.findMostEfficientTripsNew(integers,Sum);
//    }
}
