package test

import main.DeliveryLocation
import main.Drone
import main.DroneDeliveryService
import main.DroneTrip
import spock.lang.Specification


class DroneDeliveryServiceTest extends Specification {

    DroneDeliveryService droneDeliveryService = new DroneDeliveryService()
    String input = "Robbie, 45\n" +
            "School, 15\n" +
            "Hospital, 29\n" +
            "Library, 12"

    def "should return most efficient trips"() {
        given:
        def droneTrip = createDroneTrip(deliveryWeights, droneCapacity);
        when:
        def mostEfficientTrips = droneDeliveryService.findMostEfficientTrips(droneTrip)
        then:
        expectedTripsSize == mostEfficientTrips.size()
        where:
        deliveryWeights                        | droneCapacity | expectedTripsSize
        Arrays.asList(15)                      | 15            | 1
        Arrays.asList(5, 10)                   | 15            | 1
        Arrays.asList(10, 5)                   | 15            | 1
        Arrays.asList(2, 3, 5, 10)             | 15            | 2
        Arrays.asList(14, 10, 15)              | 15            | 3
        Arrays.asList(3, 1, 1, 1, 2, 2, 5, 14) | 15            | 2
        Arrays.asList(5, 10, 15, 15)           | 15            | 3
        Arrays.asList(15, 14, 15, 15)          | 15            | 4
    }

    def "should extract drone from input string"() {
        when:
        def drone = droneDeliveryService.extractDroneFromInput(input)
        then:
        drone.name == "Robbie"
        drone.capacity == 45
    }

    def "should extract delivery Locations from input string"() {
        when:
        def deliveryLocations = droneDeliveryService.extractDeliveryLocationsFromInput(input)

        then:
        3 == deliveryLocations.size()
        deliveryLocations.get(index).name == expectedName
        deliveryLocations.get(index).deliveryWeight == expectedDeliveryWeight

        where:
        expectedName | expectedDeliveryWeight | index
        "School"     | 15                     | 0
        "Hospital"   | 29                     | 1
        "Library"    | 12                     | 2
    }

    def DroneTrip createDroneTrip(List<Integer> deliveryWeights, int droneCapacity) {
        def droneTrip = new DroneTrip(new Drone("", droneCapacity))
        def locations = new ArrayList<DeliveryLocation>()
        for (Integer deliveryWeight : deliveryWeights) {
            locations.add(new DeliveryLocation("", deliveryWeight))
        }
        droneTrip.setDeliveryLocations(locations)
        droneTrip
    }

}
