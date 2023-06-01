package textRPG;

public class Player extends Creature{
	final String name;
	int mp;
	
	Player(String name) {
		this.name = name;
		this.hp = 100;
		this.mp = 100;
		this.str = 10;
	}

	@Override
	public void attack(Creature target) {
		if (target.hp >= this.str) {
			target.hp -= this.str;
		} else {
			target.hp = 0;
		}
		System.out.println(this.name + "유저가 몬스터를 공격합니다");
	}

	@Override
	public void attackByType(Creature target) {
		boolean typeHit = false;
		String typeMatch = this.type.toString() + target.type.toString();
		
		switch(typeMatch) {
		case "FIREEARTH":
		case "EARTHAIR":
		case "AIRWATER":
		case "WATERFIRE":
			typeHit = true;
		}
		
		if (target.hp >= this.str) {
			target.hp = typeHit ? target.hp - (int)(this.str * 1.5) : target.hp - this.str;
		} else {
			target.hp = 0;
		}
		
		String hitInfo = typeHit ? "[Type Hit!] " : "";
		System.out.println(hitInfo + this.name + "유저가 몬스터를 공격합니다");
		
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", mp=" + mp + ", str=" + str + ", hp=" + hp + ", type=" + type + "]";
	}
	
}
