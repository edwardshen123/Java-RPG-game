public class graphics {
    private String leftEdgeWall = "\\";
    private String rightEdgeWall = "/";

    public String hallway() {
	int size = 100;
	String hall = "";
	for (int yPixel = 0; yPixel < size; yPixel++) {
	    for (int xPixel = 0; xPixel < size; xPixel++) {
		if (xPixel == yPixel) {
		    if (xPixel < (size / 2)) {
			hall+=leftEdgeWall;
		    } else if (xPixel > (size / 2)) {
			hall+=rightEdgeWall;
		    } else {
			hall+="@";
		    }
		} else {
		    hall+=" ";
		}
	    }
	    hall+="\n";
	}
	return hall;
    }
}
