package textRPG2;

public class Monster extends Creature {
	
	Monster() {
		this.str = 10;
		this.hp = 150;
	}
	
	void attackAll(Creature[] targetArr) {
		for(int i=0; i<targetArr.length; i++) {
			attackByType(targetArr[i]);
		}
	}
	
	@Override
	public void attack(Creature target) {
		if (target.hp >= this.str) {
			target.hp -= this.str;
		} else {
			target.hp = 0;
		}
		
		String playerName = target instanceof Player ? ((Player)target).name : "";
		System.out.println("몬스터가 " + playerName + " 유저를 공격합니다" );
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
		String playerName = target instanceof Player ? ((Player)target).name : "";
		System.out.println(hitInfo + "몬스터가 " + playerName + " 유저를 공격합니다" );
	}
	

	@Override
	public String toString() {
		return "Monster [str=" + str + ", hp=" + hp + ", type=" + type + "]";
	}
	
}
