package main;

/**
 * Created by Rajbir on 9/5/15.
 */
public class DeliveryLocation implements Comparable<DeliveryLocation>{
    private String name;
    private Integer deliveryWeight;

    public DeliveryLocation(String name, Integer deliveryWeight) {
        this.name = name;
        this.deliveryWeight = deliveryWeight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDeliveryWeight() {
        return deliveryWeight;
    }

    public void setDeliveryWeight(Integer deliveryWeight) {
        this.deliveryWeight = deliveryWeight;
    }

    @Override
    public int compareTo(DeliveryLocation other) {
        return deliveryWeight.compareTo(other.deliveryWeight);
    }
}
