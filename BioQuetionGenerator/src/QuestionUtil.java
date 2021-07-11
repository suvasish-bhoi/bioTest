import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

public class QuestionUtil {
	static SplittableRandom splittableRandom = new SplittableRandom();
	List<Question> questionList = null;
	List<AnswerCompleted> answerCompleted = null;
	List<AnswerCompleted> chapterAnswerCompleted = null;

	public List<AnswerCompleted> getChapterAnswerCompleted() {
		return chapterAnswerCompleted;
	}

	public void setChapterAnswerCompleted(List<AnswerCompleted> chapterAnswerCompleted) {
		this.chapterAnswerCompleted = chapterAnswerCompleted;
	}

	public int generateRandomNumber(int min, int max) {
		return splittableRandom.nextInt(min, max+1);
	}

	public void initializeData(String chapter) {
		DataLoader dl = new DataLoader();
		switch (chapter) {
		case "11":
			questionList = dl.loadAllEleventhQuestion();
			answerCompleted = dl.loadAnswerCompleted();
			break;
		case "12":
			questionList.addAll(dl.loadAllTwelveQuestion());
			answerCompleted = dl.loadAnswerCompleted();
			break;
		case "ALL":
			questionList = dl.loadAllEleventhQuestion();
			questionList.addAll(dl.loadAllTwelveQuestion());
			answerCompleted = dl.loadAnswerCompleted();
			break;
		default:
			List<Question> tempQuestion = new ArrayList<Question>();
			tempQuestion.addAll(dl.loadAllEleventhQuestion());
			tempQuestion.addAll(dl.loadAllTwelveQuestion());
			if(questionList == null) {
				questionList = new ArrayList<Question>();
			}
			for(Question qu : tempQuestion) {
				if(qu.getChapter().equalsIgnoreCase(chapter)) {
					questionList.add(qu);
				}
			}
			chapterAnswerCompleted = dl.loadDailyAnswerCompleted();
			break;
		}
	}

	public List<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}

	public List<AnswerCompleted> getAnswerCompleted() {
		return answerCompleted;
	}

	public void setAnswerCompleted(List<AnswerCompleted> answerCompleted) {
		this.answerCompleted = answerCompleted;
	}
}
