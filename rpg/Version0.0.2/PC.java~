public class PC extends Entity {

    private int Exp;
    private Skills entitySkills = new Skills(getLevel(), Race, Job);

    //Job Variables
    private String Job;
    private int Stamina;
    private int Mana;
    private boolean isStealth;
    private int stealthTimer;
    private int Faith;

    //Race Variables
    private String Race;
    
    //Boost Variables
    private double healthPassiveBoost;
    private double strengthPassiveBoost;
    private double defensePassiveBoost;
    private double agilityPassiveBoost;
    private double intelligencePassiveBoost;
    private double precisionPassiveBoost;
    private double healthActiveBoost;
    private double strengthActiveBoost;
    private double defenseActiveBoost;
    private double agilityActiveBoost;
    private double intelligenceActiveBoost;
    private double precisionActiveBoost;

    public PC(String givenName, String givenRace, String givenJob) {
	super(givenName, "PC");
	Race = givenRace;
	Job = givenJob;
    }

    public void printSkills() {
	System.out.println(entitySkills.getSkillsList());
    }
}
