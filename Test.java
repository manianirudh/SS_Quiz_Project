import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/**
 * 
 * @author Anirudh and Isabel (check individual methods for authors)
 * This class administers the test, generating five random question from QuestionBank.
 *
 */
public class Test extends QuestionBank {
	private String name;
	private int score;
	private ArrayList <Question> testQuestions = new ArrayList(5);
	private Random rand;
	/**
	 * Author: Anirudh
	 * Default constructor for Test class
	 * Creates a random object and uses it to make a test of 5 questions
	 * Asks for user name
	 */
	public Test() {
		super();
		rand = new Random();
		for (int length = 0; length < 5; length++) {
			int size = getTestBank().size();
			int index = rand.nextInt(size);
			testQuestions.add((Question) getTestBank().get(index));
			getTestBank().remove(index);
		}
		Scanner in = new Scanner(System.in);
		System.out.print("Name: ");
		name = in.nextLine();
		System.out.println();
	}
	/**
	 * Author = Anirudh
	 * Method to administer test
	 * Prints out each part of every question
	 * Asks for user's answer choice for each question
	 * Has a conditional to increment score based on whether the user
	 * got the question correct
	 */
	public void takeTest() {
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < testQuestions.size(); i++) {
			System.out.println();
			System.out.print(i+1 + ". ");
			Question currentQuestion = testQuestions.get(i);
			System.out.println(currentQuestion.getQuestion());
			System.out.println(currentQuestion.getA());
			System.out.println(currentQuestion.getB());
			System.out.println(currentQuestion.getC());
			System.out.println(currentQuestion.getD());
			System.out.println();
			System.out.print("Your answer: ");
			String theirAnswer = in.next();
			System.out.println();
			if (theirAnswer.equalsIgnoreCase(currentQuestion.getCorrectAnswer())) {
				score++;
				System.out.println("You are correct!");
			}
			else {
				System.out.println("Not quite!");
			}
			System.out.println(currentQuestion.getExplanation());
		}
	}
	/**
	 * Author = Anirudh
	 * Method to write user's name and score onto text file
	 * Creates a text file and objects of printwriter and filewriter class
	 * Appends player's name and text to the end of the file
	 * Closes the file and printer writer
	 */
	public void addScore() {
		try {
			File file = new File("players.txt");
			FileWriter playerFile = new FileWriter(file,true);
			PrintWriter printPlayer = new PrintWriter(playerFile);
			String player = score + " " + name.toLowerCase();
			printPlayer.println(player);
			printPlayer.close();
			playerFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * Author = Anirudh
	 * Method to generate the scoreboard of an individual player
	 * Creates a temporary arrayList to hold scores of a player
	 * Reads through players.txt to check how many times the user has taken the test
	 * If user has taken it before, adds previous scores to an arrayList
	 * The arrayList is sorted and printed using helper methods
	 * Checks for a fileNotFound exception
	 */
	public void generatePersonalScoreboard() {
		try {
			ArrayList <String> playerScoreBoard = new ArrayList();
			Scanner playerScan = new Scanner(new File("players.txt"));
			Scanner lineScan = new Scanner(new File("players.txt"));
			int nameCount = 0;
			while(playerScan.hasNext()) {
				if (playerScan.next().equalsIgnoreCase(name)) {
					nameCount++;
				}
			}
			if (nameCount > 1) {
				while (lineScan.hasNextLine()) {
					String line = lineScan.nextLine();
					if (line.contains(name.toLowerCase())) {
						playerScoreBoard.add(line);
					}
				}
			}
			else {
				playerScoreBoard.add(score + " " + name.toLowerCase());
			}
			sortScoreboard(playerScoreBoard);
			printScoreboard(playerScoreBoard);
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Author = Isabel
	 * Method to generate the top score. This method creates a temporary ArrayList which is filled
	 * with the name and score of each time the test is taken. It then sorts the 
	 * ArrayList and prints the top score along with the name of each person who also
	 * achieved that top score.
	 */
	public void generateOverallScoreBoard() {
		ArrayList <String> overallScores = new ArrayList();
		try {
			Scanner overallScanner = new Scanner(new File("players.txt"));
			while (overallScanner.hasNextLine()) {
				String line = overallScanner.nextLine();
				overallScores.add(line);
			}
			sortScoreboard(overallScores);
			char topScore = overallScores.get(0).charAt(0);
			System.out.println(overallScores.get(0));
			if (overallScores.size() > 1) {
				for (int i = 1; i < overallScores.size(); i++) {
					String line = overallScores.get(i);
					if (line.charAt(0) == topScore) {
						System.out.println(line);
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Author = Isabel
	 * Uses the reverse implementation of Bubble Sort. Items that are larger float
	 * to the top of the list so that it is in descending numerical order
	 * @param list - scoreboard to be sorted
	 */
	private void sortScoreboard(ArrayList <String> list) {
		for (int outer = 0; outer < list.size() - 1; outer++){
			  for (int inner = 0; inner < list.size()-outer-1; inner++){
				  if (list.get(inner).compareTo(list.get(inner+1)) < 0){
					  String temp = list.get(inner);
					  list.set(inner, list.get(inner+1));
					  list.set(inner+1, temp);
				  }
			  }
		 }
	}
	/**
	 * Author = Isabel
	 * Prints the scoreboard. If the person has less than five scores, it prints all of 
	 * that person's scores in order. Otherwise, only the person's top five scores are printed.
	 * @param list - scoreboard to be printed
	 */
	private void printScoreboard(ArrayList <String> list) {
		int size = list.size();
		int printed = 0;
		while(printed < 5 && printed < size) {
			System.out.println(list.get(printed));
			printed++;
		}
	}

}
