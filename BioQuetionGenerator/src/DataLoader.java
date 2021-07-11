import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataLoader {
	private static final String delimeter = "\\|";
	private static final String QUESTION = "Q";
	private static final String ANSWER = "A";
	private static final String prePath = "C:\\db\\";

	public List<AnswerCompleted> loadDailyAnswerCompleted() {
		List<AnswerCompleted> answerCompleted = new ArrayList<AnswerCompleted>();
		try {
			load("dailyChapterCompleted.db", answerCompleted, ANSWER);
		} catch (Exception e) {
			System.out.println("Error while loading Answer");
			e.printStackTrace();
		}
		return answerCompleted;
	}
	
	public List<AnswerCompleted> loadAnswerCompleted() {
		List<AnswerCompleted> answerCompleted = new ArrayList<AnswerCompleted>();
		try {
			load("completed.db", answerCompleted, ANSWER);
		} catch (Exception e) {
			System.out.println("Error while loading Answer");
			e.printStackTrace();
		}
		return answerCompleted;
	}

	public List<Question> loadAllEleventhQuestion() {
		List<Question> questionList = new ArrayList<Question>();
		try {
			load("questionDetails1.db", questionList, QUESTION);
		} catch (Exception e) {
			System.out.println("Error while loading 11th question");
			e.printStackTrace();
		}
		return questionList;
	}
	
	public List<Question> loadAllTwelveQuestion() {
		List<Question> questionList = new ArrayList<Question>();
		try {
			load("questionDetails2.db", questionList, QUESTION);
		} catch (Exception e) {
			System.out.println("Error while loading 12th question");
			e.printStackTrace();
		}
		return questionList;
	}

	@SuppressWarnings("unchecked")
	private List<Question> load(String db, List listData, String type) throws FileNotFoundException {
		try {
			File file = new File(db);
			BufferedReader br = new BufferedReader(new FileReader(prePath+file));

			String line = br.readLine();
			while (line != null) {
				listData.add(type.equals(QUESTION) ? parseQuestion(line.trim()) : parseAnswer(line.trim()));
				line = br.readLine();
			}
			br.close();
		} catch (Exception e) {
			System.out.println("Error while reading " + db);
			e.printStackTrace();
		}
		return listData;
	}

	private Question parseQuestion(String line) {
		String[] splits = line.split(delimeter);
		Question question = new Question(splits[0], Integer.parseInt(splits[1]), Integer.parseInt(splits[2]),
				Integer.parseInt(splits[3]), Integer.parseInt(splits[4]));
		return question;
	}

	private AnswerCompleted parseAnswer(String line) {
		String[] splits = line.split(delimeter);
		String ansString = splits[2];
		AnswerCompleted ac = new AnswerCompleted();
		ac.setChapter(splits[0]);
		ac.setSet(Integer.parseInt(splits[1]));
		if (ansString != null && !ansString.trim().isEmpty()) {
			if(ac.getQuestion() == null) {
				ac.setQuestion(new ArrayList<String>());
			}
			for(String num : ansString.split(",")) {
				ac.getQuestion().add(num.trim());
			}
		}
		return ac;
	}
}