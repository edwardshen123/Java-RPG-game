import java.util.Arrays;

public class World {

    private static final Map<String, String[]> worldMap;
    static
    {
	worldMap = new HashMap<String, String[]>();
	worldMap.put("Freshyville", new String[] {"Eighth Floor Plain"});
	worldMap.put("Eighth Floor Plain", new String[] {"Freshyville"});
    }
    
    private String currentLocation;
    private Boolean isTown;
    private String[] locationTowns = {"Freshyville"};
    private String[] locationLink = {
	"Freshyville: Eighth Floor Plain"
    };
    
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
    public String getNextLocation() {
	int counter = 0;
	while (!locationLink[counter].contains(currentLocation)) {
	    counter++;
	}
	String link = locationLink[counter];
	String nextLocations = link.substring(currentLocation.length() + 2, link.length());
	return (nextLocations);
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
