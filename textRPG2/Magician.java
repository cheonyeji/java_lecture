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

		if (target.hp >= (int) (this.str * 1.5)) {
			target.hp = typeHit ? target.hp - (int) ((int) (this.str * 1.5) * 1.5) : target.hp - (int) (this.str * 1.5);
		} else {
			target.hp = 0;
		}

		String hitInfo = typeHit ? "[Type Hit!] " : "";
		System.out.println(hitInfo + "마법사 " + this.name + " 유저가 몬스터를 마법으로 공격합니다");

	}

}
