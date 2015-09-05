package main;

/**
 * Created by Rajbir on 9/5/15.
 */
public class Drone {
    private String name;
    private Integer capacity;

    public Drone(String name, Integer capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
