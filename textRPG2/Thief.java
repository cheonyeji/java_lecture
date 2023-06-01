package textRPG2;

public class Thief extends Player2ndLevel {
	public Thief(String name) {
		super(name);
		this.skillMp = 20;
	}

	@Override
	void skill(Creature target) {
		boolean typeHit = checkTypeHit(this.type, target.type);
		this.mp -= skillMp;

		if (target.hp >= (int) (this.str * 2)) {
			target.hp = typeHit ? target.hp - (int) ((int) (this.str * 1.5) * 2) : target.hp - (int) (this.str * 2);
		} else {
			target.hp = 0;
		}

		String hitInfo = typeHit ? "[Type Hit!] " : "";
		System.out.println(hitInfo + "도적 " + this.name + " 유저가 몬스터를 기습했습니다");

	}


}
