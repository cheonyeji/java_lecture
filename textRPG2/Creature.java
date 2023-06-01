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
}
