import java.util.List;

public class AnswerCompleted {

	private String chapter;
	private Integer set;
	private List<String> question;

	public String getChapter() {
		return chapter;
	}

	public void setChapter(String chapter) {
		this.chapter = chapter;
	}

	public Integer getSet() {
		return set;
	}

	public void setSet(Integer set) {
		this.set = set;
	}

	public List<String> getQuestion() {
		return question;
	}

	public void setQuestion(List<String> question) {
		this.question = question;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chapter == null) ? 0 : chapter.hashCode());
		result = prime * result + ((set == null) ? 0 : set.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AnswerCompleted other = (AnswerCompleted) obj;
		if (chapter == null) {
			if (other.chapter != null)
				return false;
		} else if (!chapter.equals(other.chapter))
			return false;
		if (set == null) {
			if (other.set != null)
				return false;
		} else if (!set.equals(other.set))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return chapter + "|" + set + "|" + question.toString().substring(1, question.toString().length()-1);
	}
}