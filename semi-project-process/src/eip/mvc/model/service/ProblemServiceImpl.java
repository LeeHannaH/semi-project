package eip.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import eip.mvc.model.dao.ProblemDAO;
import eip.mvc.model.dao.ProblemDAOImpl;
import eip.mvc.model.dto.ProblemVO;

public class ProblemServiceImpl implements ProblemService{
	private ProblemDAO dao = new ProblemDAOImpl();
	
	
	@Override
	public int insertProblem(ProblemVO problem) throws SQLException {
		int result = dao.insertProblem(problem);
		
		if(result == 0)
			throw new SQLException("삽입에 실패했습니다");
		
		return result;
	}

	@Override
	public List<ProblemVO> selectAll() throws SQLException {
			List<ProblemVO> list = dao.selectAll();
		return list;
	}

	
	
}

