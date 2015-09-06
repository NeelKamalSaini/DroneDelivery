package main;

import java.util.List;

public class DroneTripConsoleFormatter {

    public static void main(String[] args) throws java.lang.Exception {
        String input = "Robbie, 15\n" +
                "School, 12\n" +
                "Hospital, 5\n" +
                "Library, 10\n" +
                "Gym, 10";
        printDroneTrips(findMostEfficientTrips(input));
    }

    private static List<DroneTrip> findMostEfficientTrips(String input) {
        DroneDeliveryService droneDeliveryService = new DroneDeliveryService();
        Drone drone = droneDeliveryService.extractDroneFromInput(input);
        List<DeliveryLocation> deliveryLocations = droneDeliveryService.extractDeliveryLocationsFromInput(input);
        DroneTrip tripForAllDeliveries = new DroneTrip(drone, deliveryLocations);
        return droneDeliveryService.findMostEfficientTrips(tripForAllDeliveries);
    }

    private static void printDroneTrips(List<DroneTrip> droneTrips) {
        System.out.print(droneTrips.get(0).getDrone().getName());
        for (int i = 0; i < droneTrips.size(); i++) {
            System.out.println("\nTrip #" + (i + 1));
            List<DeliveryLocation> deliveryLocations = droneTrips.get(i).getDeliveryLocations();
            if (deliveryLocations.size() >= 1) {
                System.out.print(deliveryLocations.get(0).getName());
            }
            for (int j = 1; j < deliveryLocations.size(); j++) {
                System.out.print(", " + deliveryLocations.get(j).getName());
            }
        }
    }
}
