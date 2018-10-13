/**
 * 
 * @author Anirudh Mani
 * This class creates a question object that includes 
 * the question, answer options, correct answer and the explanation
 * The getters and setters will be implememented in later classes
 */
public class Question {
	private String ques;
	private String a, b, c, d;
	private String correctAnswer;
	private String explanation;
	
	/**
	 * Parameter constructor that takes in 7 parameters and equates it
	 * to its respective variable
	 * @param ques - question
	 * @param a - answer choice A
	 * @param b - answer choice B
	 * @param c - answer choice C
	 * @param d - answer choice D
	 * @param correctAnswer - correct answer choice
	 * @param explanation - explanation for question
	 */
	public Question(String ques, String a, String b, String c, String d, String correctAnswer, String explanation) {
		this.ques = ques;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.correctAnswer = correctAnswer;
		this.explanation = explanation;
	}
	/**
	 * 
	 * @return text of question
	 */
	public String getQuestion() {
		return ques;
	}
	/**
	 * 
	 * @return text of option A
	 */
	public String getA() {
		return a;
	}
	/**
	 * 
	 * @return text of option B
	 */
	public String getB() {
		return b;
	}
	/**
	 * 
	 * @return text of option C
	 */
	public String getC() {
		return c;
	}
	/**
	 * 
	 * @return text of option D
	 */
	public String getD() {
		return d;
	}
	/**
	 * 
	 * @return text of correct answer
	 */
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	/**
	 * 
	 * @return text of answer explanation
	 */
	public String getExplanation() {
		return explanation;
	}

}
