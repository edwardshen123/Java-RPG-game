public class Skills {

    private int level;
    private String race;
    private String job;
    
    public Skills(playerCharacter player) {
	level = player.getLevel();
	race = player.getRace();
	job = player.getJob();
    }
}
