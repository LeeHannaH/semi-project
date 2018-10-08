package eip.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import eip.mvc.model.dto.ProblemVO;

public interface ProblemDAO {
	/**
	 * 문제 추가 (관리자 계정인지 확인 후 삽입)
	 * @param : Problem
	 * @return : 0 : 실패, 1 : 성공
	 * */
	public int insertProblem(ProblemVO problem) throws SQLException;
	
	
	/**
	 * 문제 풀기 (모든계정)
	 * @return : List<Problem>
	 * */
	public List<ProblemVO> selectAll() throws SQLException;
	
	
	/**
	 * 문제 업데이트 (관리자 계정)
	 * @param : Problem 
	 * @return : int 수정된 갯수 
	 * */
	public int updateProblem(ProblemVO problem) throws SQLException;
	
	
	/**
	 * 문제 삭제(관리자 계정)
	 * @param : no 문제번호
	 * @return : int 삭제된 갯수
	 * */
	public int deleteProblem(int no) throws SQLException;
	
}
