package textRPG;

public class GameExample4 {

	public static void main(String[] args) {
		// 플레이어 객체 배열 생성 및 초기화
		Player[] party = new Player[3];
		for (int i = 0; i < party.length; i++) {
			party[i] = new Player("player" + i);
		}

		// 몬스터 생성
		Monster m1 = new Monster();

		// 공격
		System.out.println("-------- Player Attack --------");
		for (int i = 0; i < party.length; i++) {
			party[i].attack(m1);
		}
		System.out.println("-------- Monster Attack --------");
		m1.attackAll(party);

		// 정보 출력
		System.out.println("-------- Attack End --------" + "\n");
		for (int i = 0; i < party.length; i++) {
			party[i].printInfo();
		}
		m1.printInfo();
		System.out.println("\n" + "-------- Round Over --------" + "\n");

	}

}
