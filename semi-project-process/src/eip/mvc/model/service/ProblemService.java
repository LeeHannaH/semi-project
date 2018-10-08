package eip.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import eip.mvc.model.dto.ProblemVO;

public interface ProblemService {
	
	public int insertProblem(ProblemVO problem) throws SQLException;
	
	public List<ProblemVO> selectAll() throws SQLException;
}
