package textRPG2;

public class Magician extends Player2ndLevel {
	Magician(String name) {
		super(name);
		this.skillMp = 15;
	}

	@Override
	void skill(Creature target) {
		boolean typeHit = checkTypeHit(this.type, target.type);
		this.mp -= skillMp;
		
		if(typeHit)
			decreaseHpTypeHitBySkill(target, 1.5);
		else
			decreaseHpBySkill(target, 1.5);

		String hitInfo = typeHit ? "[Type Hit!] " : "";
		System.out.println(hitInfo + "마법사 " + this.name + " 유저가 몬스터를 마법으로 공격합니다");

	}

	@Override
	public String toString() {
		return "Magician [skillMp=" + skillMp + ", name=" + name + ", mp=" + mp + ", str=" + str + ", hp=" + hp
				+ ", type=" + type + "]";
	}
	
	

}
