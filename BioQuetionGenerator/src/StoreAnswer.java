import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class StoreAnswer {
	private static final String ANSWER_LOG = "answerLogger.db";
	private static final String COMPLETE_ANSWER_DB = "completed.db";
	private static final String COMPLETE_CHAPTER_ANSWER_DB = "dailyChapterCompleted.db";
	private static final String prePath = "C:\\db\\";

	public void writeLog(String lineToAdd) {
		try {
			File oldFile = new File(prePath + ANSWER_LOG);
			File newFile = new File(prePath + ANSWER_LOG + "_1");
			newFile.createNewFile();
			BufferedReader br = new BufferedReader(new FileReader(oldFile));
			BufferedWriter bw = new BufferedWriter(new FileWriter(newFile));

			String line = br.readLine();
			while (line != null) {
				bw.write(line);
				line = br.readLine();
				bw.newLine();
			}
			br.close();
			bw.write(lineToAdd);
			bw.close();
			oldFile.delete();
			newFile.renameTo(oldFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeAnswerData(List<AnswerCompleted> answer) {
		try {
			File oldFile = new File(prePath + COMPLETE_ANSWER_DB);
			File newFile = new File(prePath + COMPLETE_ANSWER_DB + "_1");

			BufferedWriter bw = new BufferedWriter(new FileWriter(newFile));

			for (AnswerCompleted answerCompleted : answer) {
				bw.write(answerCompleted.toString());
				bw.newLine();
			}
			bw.flush();
			bw.close();
			oldFile.delete();
			newFile.renameTo(oldFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void writeChapterAnswerData(List<AnswerCompleted> answer) {
		try {
			File oldFile = new File(prePath + COMPLETE_CHAPTER_ANSWER_DB);
			File newFile = new File(prePath + COMPLETE_CHAPTER_ANSWER_DB + "_1");

			BufferedWriter bw = new BufferedWriter(new FileWriter(newFile));

			for (AnswerCompleted answerCompleted : answer) {
				bw.write(answerCompleted.toString());
				bw.newLine();
			}
			bw.flush();
			bw.close();
			oldFile.delete();
			newFile.renameTo(oldFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}