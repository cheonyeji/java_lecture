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
		
		if (target.hp >= (int)(this.str * 1.2)) {
			target.hp = typeHit ? target.hp - (int)((int)(this.str * 1.5)*1.2) : target.hp - (int)(this.str * 1.2);
		} else {
			target.hp = 0;
		}
		
		String hitInfo = typeHit ? "[Type Hit!] " : "";
		System.out.println(hitInfo + "전사 " + this.name + " 유저가 몬스터를 칼로 공격합니다");
	
	}

	@Override
	public String toString() {
		return "Warrior [name=" + name + ", mp=" + mp + ", str=" + str + ", hp=" + hp + ", type=" + type + "]";
	}

}
