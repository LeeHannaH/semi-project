package eip.mvc.model.dto;

public class ErrorVO {
	private String id;
	private ProblemVO problem;
	private int errorAnswer;
	private int ecount;
	
	
	
	public ErrorVO() {}
	
	
	public ErrorVO(String id, ProblemVO problem, int errorAnswer, int ecount) {
		this.id = id;
		this.problem = problem;
		this.errorAnswer = errorAnswer;
		this.ecount = ecount;//중복일 경우에 ++ 해줘야 함
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ProblemVO getProblem() {
		return problem;
	}
	public void setProblem(ProblemVO problem) {
		this.problem = problem;
	}
	public int getErrorAnswer() {
		return errorAnswer;
	}
	public void setErrorAnswer(int errorAnswer) {
		this.errorAnswer = errorAnswer;
	}
	public int getEcount() {
		return ecount;
	}
	public void setEcount(int ecount) {
		this.ecount = ecount;
	}
	@Override
	public String toString() {
		return "Error [id=" + id + ", problem=" + problem + ", errorAnswer=" + errorAnswer + ", ecount=" + ecount + "]";
	}
	
	
}
