import java.util.Maps;
import java.util.HashMap;

public class NPC extends Entity {

    private static final Map<String, int> npcExpMap = new HashMap<String, int>();
    static
    {
	npcExpMap.put("zombie", 20);
    }
    private int[] threat = {0, 0, 0, 0};
    
    public NPC(String givenName) {
	super(givenName, givenName);
    }
    
    public int[] getThreat() {
	return threat;
    }
    public void setThreat(int a, int b, int c, int d) {
	threat[0] = a;
	threat[1] = b;
	threat[2] = c;
	threat[3] = d;
    }
    public int getKillExp() {
	return npcExpMap.get(givenName);
    }
}
