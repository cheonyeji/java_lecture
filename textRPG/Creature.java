package textRPG;

import textRPG2.Type;

public abstract class Creature implements Attackable, TypeAttackable{
	int str;
	int hp;
	Type type;
	
	Creature (){
		// type 랜덤 생성
		//Type[] typeArr = {Type.WATER, Type.AIR, Type.FIRE, Type.EARTH};
		Type[] types = Type.values();
		
		// Math.random() -> 0~1 사이의 랜덤한 소수숫자
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
	
	void decreaseHpTypeHit(Creature target) {
		if(target.hp >= (int)(this.str * 1.5)) {
			target.hp -= (int)(this.str * 1.5);
		} else {
			target.hp = 0;
		}
	}
	
	void decreaseHp(Creature target) {
		if (target.hp >= this.str) {
			target.hp -= this.str;
		} else {
			target.hp = 0;
		}
	}

}
