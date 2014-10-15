import java.util.Random;

public class Slime extends basicCharacter {

    public Slime() {
	super("slime", 1, 10, 2, 20, 1, 1, 1, 1, 1, 20, 5);
	Random randInt = new Random();
	int[] baseStat = getStat();
	for (int counter = 0; counter < baseStat.size(); counter++) {
	    baseStat[counter] = baseStat[counter] * (randInt.nextInt(2) + 1);
	}
	setStat(baseStat);
    }
}
