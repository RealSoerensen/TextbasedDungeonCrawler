package zuulGame;

public class Room {
	Monster monster;
	
	/**
	 * Creates the room object to take an int as parameter to create a monster.
	 * @param multiplier
	 */
	public Room(int multiplier){
		monster = new Monster(multiplier);
	}
	
	public Monster getMonster() {
		return monster;
	}
}
