package main;

import java.util.List;

/**
 * Created by Rajbir on 9/5/15.
 */
public class DroneTripNew {
    private String droneName;
    private List<String> locationNames;


    public List<String> getLocationNames() {
        return locationNames;
    }

    public void setLocationNames(List<String> locationNames) {
        this.locationNames = locationNames;
    }

    public String getDroneName() {
        return droneName;
    }

    public void setDroneName(String droneName) {
        this.droneName = droneName;
    }
}
