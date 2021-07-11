import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GeneratorUtil {

	private QuestionUtil qu;
	private List<Question> questionList;
	private List<AnswerCompleted> answerGenerate = new ArrayList<AnswerCompleted>();

	public GeneratorUtil() {
		super();
		qu = new QuestionUtil();
	}

	public void generateForEleventh(Integer maxQuestion) {
		qu.initializeData("11");
		questionList = qu.getQuestionList();
		List<AnswerCompleted> answerCompletedList = qu.getAnswerCompleted();
		int totalChapter = 22;
		int totalQuestionPerChapter = maxQuestion / totalChapter;
		if (totalQuestionPerChapter == 0) {
			totalQuestionPerChapter = 1;
		}
		for (int i = 1; i <= maxQuestion; i++) {

		}
	}

	public void generateForTwelve(Integer maxQuestion) {
		qu.initializeData("12");
		questionList = qu.getQuestionList();
		List<AnswerCompleted> answerCompletedList = qu.getAnswerCompleted();
	}

	public void generateForAll(Integer maxQuestion) {
		qu.initializeData("ALL");
		questionList = qu.getQuestionList();
		List<AnswerCompleted> answerCompletedList = qu.getAnswerCompleted();
	}

	public void generateForChapter(Integer maxQuestion, String chapter) {
		qu.initializeData(chapter);
		questionList = qu.getQuestionList();
		List<AnswerCompleted> answerCompletedList = qu.getChapterAnswerCompleted();
		List<Question> qList = new ArrayList<Question>();
		for (Question qq : questionList) {
			if (qq.getChapter().equals(chapter)) {
				qList.add(qq);
			}
		}

		Integer numberOfQuestionObject = 0;
		List<Integer> setCompleted = new ArrayList<Integer>();
		finish: for (int i = 0; i < maxQuestion; i++) {
			if (setCompleted.size() == qList.size()) {
				System.out.println("End of question");
				break;
			}
			if (setCompleted.contains(numberOfQuestionObject)) {
				if (numberOfQuestionObject == qList.size() - 1) {
					numberOfQuestionObject = 0;
				} else if (numberOfQuestionObject < qList.size() - 1) {
					numberOfQuestionObject++;
				}
				i--;
				continue;
			}
			checkNext: for (Question qq : questionList) {
				if (setCompleted.contains(qq.getSet() - 1)) {
					continue checkNext;
				}
				for (AnswerCompleted ac : answerCompletedList) {
					if (ac.getChapter().equals(qq.getChapter()) && ac.getSet().equals(qq.getSet())) {
						if (ac.getQuestion().size() == qq.getQuestionCount()) {
							// check in next set
							setCompleted.add(qq.getSet() - 1);
							if (numberOfQuestionObject == qq.getSet()) {
								if (numberOfQuestionObject == qList.size() - 1) {
									numberOfQuestionObject = 0;
								} else if (numberOfQuestionObject < qList.size() - 1) {
									numberOfQuestionObject++;
								}
							}
							continue finish;
						}
					}
				}
			}
			Integer questionNumber = getNewQuestionNumber(qList.get(numberOfQuestionObject), answerCompletedList);
			System.out.println(i + 1 + " > Chapter : " + qList.get(numberOfQuestionObject).getChapter() + "Set : "
					+ qList.get(numberOfQuestionObject).getSet() + " Question : " + questionNumber);
			if (numberOfQuestionObject == qList.size() - 1) {
				numberOfQuestionObject = 0;
			} else if (numberOfQuestionObject < qList.size() - 1) {
				numberOfQuestionObject++;
			}
		}
		StoreAnswer sa = new StoreAnswer();
		sa.writeChapterAnswerData(answerCompletedList);
		sa.writeLog(new Timestamp(System.currentTimeMillis()) + " : " + chapter + " Chapter " + maxQuestion
				+ " question generated");
	}

	private Integer getNewQuestionNumber(Question question, List<AnswerCompleted> answerCompleted) {
		Integer number = null;
		if (answerCompleted.isEmpty()) {
			AnswerCompleted ac = new AnswerCompleted();
			ac.setChapter(question.getChapter());
			ac.setSet(question.getSet());
			ac.setQuestion(new ArrayList<String>());
			answerCompleted.add(ac);
		} else {
			boolean chapterSetFound = false;
			proceed: for (AnswerCompleted ac : answerCompleted) {
				if (ac.getChapter().equals(question.getChapter()) && ac.getSet().equals(question.getSet())) {
					chapterSetFound = true;
					break proceed;
				}
			}
			if (!chapterSetFound) {
				AnswerCompleted ac = new AnswerCompleted();
				ac.setChapter(question.getChapter());
				ac.setSet(question.getSet());
				ac.setQuestion(new ArrayList<String>());
				answerCompleted.add(ac);
			}
		}

		while (number == null) {
			String temp = String.valueOf(qu.generateRandomNumber(1, question.getQuestionCount()));
			whole: for (AnswerCompleted ac : answerCompleted) {
				if (ac.getChapter().equals(question.getChapter()) && ac.getSet().equals(question.getSet())) {
					if (!ac.getQuestion().contains(temp)) {
						number = Integer.parseInt(temp);
						ac.getQuestion().add(temp.trim());
						break whole;
					}
				}
			}
		}
		return number;
	}
}