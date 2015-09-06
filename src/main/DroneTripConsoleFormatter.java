package main;

import java.util.List;

/**
 * Created by Rajbir on 9/5/15.
 */
public class DroneTripConsoleFormatter {

    public static void main(String[] args) throws java.lang.Exception {
        DroneDeliveryService droneDeliveryService = new DroneDeliveryService();
        String input = "Robbie, 15\n" +
                "School, 12\n" +
                "Hospital, 5\n" +
                "Library, 10\n" +
                "Gym, 10";
        List<DroneTrip> droneTrips = droneDeliveryService.summarizeMostEfficientTrips(input);
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
