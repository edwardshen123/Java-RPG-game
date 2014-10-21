public class NPC extends Entity {

    private int killExp;
    
    public NPC(String givenName) {
	super(givenName, givenName);
    }
    
    public int getKillExp() {
	return killExp;
    }
}
