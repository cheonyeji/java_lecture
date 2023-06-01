package textRPG;

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
}
