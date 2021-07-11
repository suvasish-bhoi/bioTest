import java.util.List;

/**
 * @author SBhoi
 *
 */
public class FinalOutput {

	private String chapter;
	private Integer set;
	private List<Integer> quetions;
	private Integer pageStart;
	private Integer pageEnd;

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

	public List<Integer> getQuetions() {
		return quetions;
	}

	public void setQuetions(List<Integer> quetions) {
		this.quetions = quetions;
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
		FinalOutput other = (FinalOutput) obj;
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
		return "FinalOutput [chapter=" + chapter + ", set=" + set + ", quetions=" + quetions + ", pageStart="
				+ pageStart + ", pageEnd=" + pageEnd + "]";
	}

}