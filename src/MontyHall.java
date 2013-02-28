import java.util.Random;

/**
 * solution for http://en.wikipedia.org/wiki/Monty_Hall_problem
 * @author Basav Nagur
 *
 */
public class MontyHall {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int staywins = 0;
		int switchwins = 0;

		System.out.println(String.format("%5s %5s %5s  %5s", "prize_door", "user_choice", "shown", "switch_doors"));
		for (int i = 0; i < 1000 ; i++) {
			int[] doors = { 0, 0, 0 };	//0 for goat and 1 for gold

			Random random = new Random();
			int prize_door = random.nextInt(3);
			
			doors[prize_door] = 1;

			int user_choice = random.nextInt(3);
			
			staywins += doors[user_choice];
			
			int shown = getRandomExclude(user_choice, prize_door);
			
			int switch_doors = getRandomExclude(shown, user_choice);
			switchwins += doors[switch_doors];
			System.out.println(String.format("%5s %9s %11s  %9s", prize_door,user_choice,shown,switch_doors));
		}
		
		System.out.println("Stay Wins "+staywins);
		System.out.println("Switch Wins "+ switchwins);
	}

	private static int getRandomExclude(int x, int y) {
	int randomGuess;
	Random random = new Random();
		do {

			randomGuess = random.nextInt(3);

		} while (randomGuess == x || randomGuess == y);
		
		return randomGuess;
	}

}
