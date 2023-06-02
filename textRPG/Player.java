package textRPG;

public class Player extends Creature {
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
		
		// Type.EARTH.toString() -> "EARTH"
		
		
		String typeMatch = this.type.toString() + target.type.toString();
		if (typeMatch.equals("FIREEARTH") || typeMatch.equals("EARTHAIR") 
				|| typeMatch.equals("AIRWATER") || typeMatch.equals("WATERFIRE")) {
			// 속성이 우세할때 (str * 1.5만큼 데미지)
			if(target.hp >= (int)(this.str * 1.5)) {
				target.hp -= (int)(this.str * 1.5);
			} else {
				target.hp = 0;
			}
		} else {
			// 아닐때 (str만큼 데미지)
			if (target.hp >= this.str) {
				target.hp -= this.str;
			} else {
				target.hp = 0;
			}
		}
		
		boolean typeHit = checkTypeHit(this.type, target.type);
		
		// typeHit일때는 str1.5배보다 hp가 많이 남았나 체크해야함
		if(typeHit) decreaseHpTypeHit(target); 
		else decreaseHp(target);

		String hitInfo = typeHit ? "[Type Hit!] " : "";
		System.out.println(hitInfo + this.name + "유저가 몬스터를 공격합니다");
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", mp=" + mp + ", str=" + str + ", hp=" + hp + ", type=" + type + "]";
	}

}
