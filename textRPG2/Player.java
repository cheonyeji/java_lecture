package textRPG2;

public class Player extends Creature{
	// 필드
	final String name;
	int mp;
	
	// 생성자
	Player(String name) {
		this.name = name;
		this.hp = 100;
		this.mp = 100;
		this.str = 10;
	}
	
	
	// 구현 메서드
	@Override
	public void attack(Creature target) {
		if (target.hp >= this.str) {
			target.hp -= this.str;
		} else {
			target.hp = 0;
		}
		System.out.println(this.name + " 유저가 몬스터를 공격합니다");
	}

	@Override
	public void attackByType(Creature target) {
		boolean typeHit = checkTypeHit(this.type, target.type);
		
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
