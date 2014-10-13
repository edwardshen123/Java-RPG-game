public class Encounter {
    public void slimeEncounter(Novice user) {
	System.out.println("You have encountered a slime");
	Slime slime = new Slime();
	while (true) {
	    System.out.println("You have attacked the slime for " + user.attack(slime, 0) + " damage");
	    if (slime.isDead()) {
		System.out.println("You have vanquished the slime");
		System.out.println("You gained " + slime.getExp() + " experience and " + slime.getGold() + " gold!");
		user.gainExp(slime.getExp());
		user.gainGold(slime.getGold());
		break;
	    }
	    System.out.println("Slime has attacked you for " + slime.attack(user, 0) + " damage");
	    if (user.isDead()) {
		System.out.println("You have been vanquished by the slime");
		System.out.println("Game Over");
		break;
	    }
	}
    }
}
