public class World {
    
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
	return ("You have traveled to " + currentLocation);
    }
    public String[] actionOptions() {
	if (isTown) {
	    return (new String[] {"Changing Room", "Locker", "Nurse\'s Office", "Exit Area"});
	} else {
	    return (new String[] {"Search", "Camp", "Exit Area"});
	}
    }
}
