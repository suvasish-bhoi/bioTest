public class GenerateQuestion {

	public static void main(String[] args) {
		Integer maxQuestion = Integer.parseInt(args[0]);
		String chapter = args[1];

		new GeneratorUtil().generateForChapter(maxQuestion, chapter);
		/*
		 * switch (chapter) { case "11": new
		 * GeneratorUtil().generateForEleventh(maxQuestion); break; case "12": new
		 * GeneratorUtil().generateForTwelve(maxQuestion); break; case "ALL": new
		 * GeneratorUtil().generateForAll(maxQuestion); break; default: new
		 * GeneratorUtil().generateForChapter(maxQuestion, chapter); break; }
		 */
	}

}
