public class NPC extends Entity {

    private String[] npcList = {"zombie"};
    private int[] expList = {0};
    private int killExp;
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
	return killExp;
    }
}
