package main;


public class Application {
    public static void main(String[] args) throws Exception {
        String input = "Robbie, 15\n" +
                "School, 12\n" +
                "Hospital, 5\n" +
                "Library, 10\n" +
                "Gym, 10";
        ConsoleFormatter.printDroneTrips(ConsoleFormatter.findMostEfficientTrips(input));
    }
}
