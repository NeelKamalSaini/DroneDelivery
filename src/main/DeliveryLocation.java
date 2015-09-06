package main;


public class DeliveryLocation implements Comparable<DeliveryLocation> {
    private String name;
    private Integer deliveryWeight;

    public DeliveryLocation(String name, Integer deliveryWeight) {
        this.name = name;
        this.deliveryWeight = deliveryWeight;
    }

    public String getName() {
        return name;
    }

    public Integer getDeliveryWeight() {
        return deliveryWeight;
    }

    @Override
    public int compareTo(DeliveryLocation other) {
        return deliveryWeight.compareTo(other.deliveryWeight);
    }
}
