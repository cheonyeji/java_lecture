package textRPG2;

public class Monster extends Creature {

	Monster() {
		this.str = 10;
		this.hp = 150;
	}

	void attackAll(Creature[] targetArr) {
		for (int i = 0; i < targetArr.length; i++) {
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

		String playerName = target instanceof Player ? ((Player) target).name : "";
		System.out.println("몬스터가 " + playerName + " 유저를 공격합니다");
	}

	@Override
	public void attackByType(Creature target) {
		boolean typeHit = checkTypeHit(this.type, target.type);

		// typeHit일때는 str1.5배보다 hp가 많이 남았나 체크해야함
		if (typeHit)
			decreaseHpTypeHit(target);
		else
			decreaseHp(target);

		String hitInfo = typeHit ? "[Type Hit!] " : "";
		String playerName = target instanceof Player ? ((Player) target).name : "";
		System.out.println(hitInfo + "몬스터가 " + playerName + " 유저를 공격합니다");
	}

	@Override
	public String toString() {
		return "Monster [str=" + str + ", hp=" + hp + ", type=" + type + "]";
	}

}
