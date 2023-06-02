package textRPG2;

public abstract class Player2ndLevel extends Player {
	int skillMp;
	
	Player2ndLevel(String name) {
		super(name);
	}
	
	// 추상 메서드
	abstract void skill(Creature target);

	
	void decreaseHpTypeHitBySkill(Creature target, double bonus) {
		if(target.hp >= (int)((int)(this.str * 1.5) * bonus)) {
			target.hp -= (int)((int)(this.str * 1.5) * bonus);
		} else {
			target.hp = 0;
		}
	}

	void decreaseHpBySkill(Creature target, double bonus) {
		if (target.hp >= (int)(this.str * bonus)) {
			target.hp -= (int)(this.str * bonus);
		} else {
			target.hp = 0;
		}
	}
	
	
	
}
