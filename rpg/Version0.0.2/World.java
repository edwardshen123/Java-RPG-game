public class World {
    
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
    public String move(String nextLocation) {
	currentLocation = nextLocation;
	return ("You have traveled to " + currentLocation);
    }
    public String[] actionOptions() {
	if (isTown) {
	    return (new String[] {"Armor\'s Shop", "Nurse\'s Office"});
	} else {
	    return (new String[] {"Search", "Camp"});
	}
    }
}
