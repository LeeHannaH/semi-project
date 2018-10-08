package eip.mvc.model.dto;

public class ProblemVO {
	private int no;
	private String kind;
	private String problem;
	private int answer;
	private String explain;
	private String Keyword;
	private double incorrect;
	
	
	
	public ProblemVO() {}
	
	public ProblemVO(int no, String kind, String problem, int answer, String explain) {
		this.no = no;
		this.kind = kind;
		this.problem = problem;
		this.answer = answer;
		this.explain = explain;
	}
	
	public ProblemVO(int no, String kind, String problem, int answer, String explain, String keyword, double incorrect) {
		this(no,kind,problem,answer,explain);
		this.Keyword = keyword;
		this.incorrect = incorrect;
	}
	

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	public String getKeyword() {
		return Keyword;
	}

	public void setKeyword(String keyword) {
		Keyword = keyword;
	}

	public double getIncorrect() {
		return incorrect;
	}

	public void setIncorrect(double incorrect) {
		this.incorrect = incorrect;
	}

	@Override
	public String toString() {
		return "Problem [no=" + no + ", kind=" + kind + ", problem=" + problem + ", answer=" + answer + ", explain="
				+ explain + ", Keyword=" + Keyword + ", incorrect=" + incorrect + "]";
	}
}
