public class Warrior extends basicCharacter {
    
    //Unique stat
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
    
    //Action methods (Skills)
    public void warriorConstitution() {
    }
    public void hackNbash() {
    }
}
