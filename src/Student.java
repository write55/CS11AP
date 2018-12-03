
public class Student {

	// PRIVATE DATA
	private int id;
	private int score;
	private char course;

	// CONSTRUTOR
	public Student(int id, int score, char course) {
		this.id = id;
		this.score = score;
		this.course = course;
	}

	// GETTERS
	public int getId() {
		return id;
	}

	public int getScore() {
		return score;
	}

	public char getCourse() {
		return course;
	}

	// SETTERS
	public void setId(int id) {
		this.id = id;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setCourse(char course) {
		this.course = course;
	}

	public static String convertCode(char code) {
		switch (code) {
		case 'C':
			return "Computer Science";
		case 'E':
			return "Education";
		case 'M':
			return "Mathematics";
		case 'B':
			return "Business";
		case 'N':
			return "Engineering";
		case 'A':
			return "Art";
		default:
			return "Incorrect Course Code";
		}
	}

	// TOSTRING
	public String toString() {
		return "Id: " + getId() + "\nScore: " + getScore() + "\nCourse: " + convertCode(getCourse());
	}

}
