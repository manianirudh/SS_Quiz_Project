import java.util.*;
import java.io.File;
/**
 * 
 * @author Isabel Suizo
 * This test compiles all of the data from the text files to create 20 questions which
 * make up the QuestionBank.
 */
public class QuestionBank {
	private ArrayList <Question> testBank = new ArrayList<Question>(20);
	
	/**
	 * Default constructor which scans the data from the questions, options, correctAnswers, and explanations 
	 * text files. The following data is then used to create a new Question object which is added
	 * to the testBank ArrayList. This process is repeated for all 20 questions. 
	 */
	public QuestionBank() {
		try {
			Scanner quesScan = new Scanner(new File("questions.txt"));
			Scanner optionScan = new Scanner(new File("options.txt"));
			Scanner correctAnswerScan = new Scanner(new File("correctAnswers.txt"));
			Scanner explanationScan = new Scanner(new File("explanations.txt"));
			for (int numOfQuestions = 0; numOfQuestions < 20; numOfQuestions++) {
				String question = quesScan.nextLine();
				String optionA = optionScan.nextLine();
				String optionB = optionScan.nextLine();
				String optionC = optionScan.nextLine();
				String optionD = optionScan.nextLine();
				String correct = correctAnswerScan.nextLine();
				int explanationLength = explanationScan.nextInt();
				explanationScan.nextLine();
				String explanation = "";
				for (int i = 0; i < explanationLength; i++) {
					explanation += explanationScan.nextLine() + "\n";
				}
				testBank.add(new Question(question,optionA,optionB,optionC,optionD,correct, explanation));
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 * Getter method for testBank 
	 * @return testBank - ArrayList of all 20 questions
	 */
	public ArrayList getTestBank() {
		return testBank;
	}

	

}

