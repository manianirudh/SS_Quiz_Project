import java.util.Scanner;
/**
 * 
 * @author Isabel Suizo
 * Period 1
 * Driver for Test class. This class prompts the user for whether they want to take the test and their name.
 * The test taker is then fed 5 questions, one at a time. At the end, the test taker's personal scoreboard 
 * and the all-time high score are printed. The user is then asked if he/she wants to take the test again, and a
 * new, randomized test is administered. 
 */
public class QuizDriver {
	/**
	 * 
	 * @param args - part of main method
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Would you like to take the test? ");
		String response = in.next();
		while (response.toLowerCase().equals("yes") || response.toLowerCase().equals("y")) {
			Test tester = new Test();
			tester.takeTest();
			tester.addScore();
			System.out.println("Your personal scoreboard: ");
			tester.generatePersonalScoreboard();
			System.out.println();
			System.out.println("Top all-time score: ");
			tester.generateOverallScoreBoard();
			System.out.println();
			System.out.print("Would you like to take the test again? ");
			response = in.next();
		}
		System.out.println("\n"+ "Thank you for taking the test!");
	}
}