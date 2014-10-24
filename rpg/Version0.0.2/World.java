import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class World {

    private static final Map<String, String[]> worldMap = new HashMap<String, String[]>();
    static
    {
	worldMap.put("Freshyville", new String[] {"Eighth Floor Plain"});
	worldMap.put("Eighth Floor Plain", new String[] {"Freshyville"});
    }
    
    private String currentLocation;
    private Boolean isTown;
    private String[] locationTowns = {"Freshyville"};
    
    public World() {
	currentLocation = "Freshyville";
	isTown = true;
    }
    public World(String lastLocation) {
	currentLocation = lastLocation;
    }

    public String getLocation() {
	return currentLocation;
    }
    public String[] getNextLocations() {
        return worldMap.get(currentLocation);
    }
    public String move(String nextLocation) {
	currentLocation = nextLocation;
	if (Arrays.asList(locationTowns).contains(nextLocation)) {
	    isTown = true;
	} else {
	    isTown = false;
	}
	return ("You have traveled to " + currentLocation);
    }
    public String[] actionOptions() {
	if (isTown) {
	    return (new String[] {"Changing Room", "Locker", "Nurse\'s Office", "Area"});
	} else {
	    return (new String[] {"Battle", "Search", "Camp", "Area"});
	}
    }
}
