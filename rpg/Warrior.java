public class Warrior extends basicCharacter {
    
    //instance variable
    private int stamina = 10;

    //constructors
    public Warrior(Novice user) {
	super(user.toString(), user.getStat());
    }

    //methods
    public void levelUp() {
	super.levelUp();
	stamina++;
    }
    public void warriorConstitution() {
    }
    public void hackNbash() {
    }
}
