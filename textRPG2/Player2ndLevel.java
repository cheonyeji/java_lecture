package textRPG2;

public abstract class Player2ndLevel extends Player {
	int skillMp;
	
	Player2ndLevel(String name) {
		super(name);
	}
	
	// 추상 메서드
	abstract void skill(Creature target);

}
