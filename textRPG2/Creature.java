package textRPG2;

public abstract class Creature implements Attackable, TypeAttackable{
	int str;
	int hp;
	Type type;
	
	Creature (){
		// type 랜덤 생성
		Type[] types = Type.values();
		this.type = types[(int) (Math.random() * 4)];
	}
	
	void printInfo() {
		System.out.println(this.toString());
	}
	
	boolean checkTypeHit(Type attack, Type defense) {
		boolean typeHit = false;
		String typeMatch = attack.toString() + defense.toString();
		// 공격수비 순서로 기록
		switch(typeMatch) {
		case "FIREEARTH":
		case "EARTHAIR":
		case "AIRWATER":
		case "WATERFIRE":
			typeHit = true;
		}
		return typeHit;
	}
	
	// typeHit 발생했을 때 str의 1.5배만큼 체력 감소
	void decreaseHpTypeHit(Creature target) {
		if(target.hp >= (int)(this.str * 1.5)) {
			target.hp -= (int)(this.str * 1.5);
		} else {
			target.hp = 0;
		}
	}
	
	// typeHit 발생했을 때 str만큼 체력 감소
	void decreaseHp(Creature target) {
		if (target.hp >= this.str) {
			target.hp -= this.str;
		} else {
			target.hp = 0;
		}
	}

}
