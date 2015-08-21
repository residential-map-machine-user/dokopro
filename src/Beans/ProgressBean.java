package Beans;

public class ProgressBean{
	private int contentsId = 0;
	private float completeCount = 0;
	private float questionCount = 0;
	private float progress = 0;
	private String contentsTitle = "";
	public String getContentsTitle() {
		return contentsTitle;
	}
	public void setContentsTitle(String contentsTitle) {
		this.contentsTitle = contentsTitle;
	}
	public void progresCalc(){
		float progress = 0;
		if(questionCount > 0 && completeCount > 0){
			progress =(completeCount / questionCount) * 100;
			this.progress = progress;
		}else{
			System.out.println("問題の総数と回答数が取得されていません");
		}
	}
	public int getContentsId() {
		return contentsId;
	}
	public void setContentsId(int contentsId) {
		this.contentsId = contentsId;
	}
	public float getCompleteCount() {
		return completeCount;
	}
	public void setCompleteCount(int completeCount) {
		this.completeCount = completeCount;
	}
	public float getQuestionCount() {
		return questionCount;
	}
	public void setQuestionCount(int questionCount) {
		this.questionCount = questionCount;
	}
	public float getProgress() {
		return progress;
	}
	public void setProgress(int progress) {
		this.progress = progress;
	}
}
