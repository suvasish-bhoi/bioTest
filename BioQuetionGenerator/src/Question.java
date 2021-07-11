public class Question {
	private String chapter;
	private Integer pageStart;
	private Integer pageEnd;
	private Integer set;
	private Integer questionCount;

	public Question(String chapter, Integer pageStart, Integer pageEnd, Integer set, Integer questionCount) {
		super();
		this.chapter = chapter;
		this.pageStart = pageStart;
		this.pageEnd = pageEnd;
		this.set = set;
		this.questionCount = questionCount;
	}

	public String getChapter() {
		return chapter;
	}

	public void setChapter(String chapter) {
		this.chapter = chapter;
	}

	public Integer getPageStart() {
		return pageStart;
	}

	public void setPageStart(Integer pageStart) {
		this.pageStart = pageStart;
	}

	public Integer getPageEnd() {
		return pageEnd;
	}

	public void setPageEnd(Integer pageEnd) {
		this.pageEnd = pageEnd;
	}

	public Integer getSet() {
		return set;
	}

	public void setSet(Integer set) {
		this.set = set;
	}

	public Integer getQuestionCount() {
		return questionCount;
	}

	public void setQuestionCount(Integer questionCount) {
		this.questionCount = questionCount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chapter == null) ? 0 : chapter.hashCode());
		result = prime * result + ((pageEnd == null) ? 0 : pageEnd.hashCode());
		result = prime * result + ((pageStart == null) ? 0 : pageStart.hashCode());
		result = prime * result + ((questionCount == null) ? 0 : questionCount.hashCode());
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
		Question other = (Question) obj;
		if (chapter == null) {
			if (other.chapter != null)
				return false;
		} else if (!chapter.equals(other.chapter))
			return false;
		if (pageEnd == null) {
			if (other.pageEnd != null)
				return false;
		} else if (!pageEnd.equals(other.pageEnd))
			return false;
		if (pageStart == null) {
			if (other.pageStart != null)
				return false;
		} else if (!pageStart.equals(other.pageStart))
			return false;
		if (questionCount == null) {
			if (other.questionCount != null)
				return false;
		} else if (!questionCount.equals(other.questionCount))
			return false;
		if (set == null) {
			if (other.set != null)
				return false;
		} else if (!set.equals(other.set))
			return false;
		return true;
	}
}
