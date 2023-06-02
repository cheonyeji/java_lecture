package textRPG2;

public class Warrior extends Player2ndLevel {
	
	Warrior(String name) {
		super(name);
		this.skillMp = 10;
	}

	@Override
	void skill(Creature target) {
		boolean typeHit = checkTypeHit(this.type, target.type);
		this.mp -= skillMp;
		
		if(typeHit)
			decreaseHpTypeHitBySkill(target, 1.2);
		else
			decreaseHpBySkill(target, 1.2);
		
		String hitInfo = typeHit ? "[Type Hit!] " : "";
		System.out.println(hitInfo + "전사 " + this.name + " 유저가 몬스터를 칼로 공격합니다");
	
	}

	@Override
	public String toString() {
		return "Warrior [skillMp=" + skillMp + ", name=" + name + ", mp=" + mp + ", str=" + str + ", hp=" + hp
				+ ", type=" + type + "]";
	}

	
}
