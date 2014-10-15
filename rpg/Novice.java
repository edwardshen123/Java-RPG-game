public class Novice extends basicCharacter {

    //Limiter
    private int levelCap = 10;



    //constructors
    public Novice(String initName) {
	super(initName);
    }



    //methods
    //overload methods
    public void levelUp() {
	//if level is not at cap, then it can level
	if (getLevel() + 1 <= levelCap) {
	    super.levelUp();
	}
    }

    //Qualifier methods
    public boolean promoChecker() {
	return (getLevel() == levelCap);
    }

    //action methods(skills)
    public void noviceConstitution() {
	buffHealth(20);
    }

}
