package eip.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import eip.mvc.model.dto.ErrorVO;

public interface ErrorDAO {
	/**
	 * 오답추가  - 문제틀리면 오답노트에 추가
	 * @param ID : 현재 로그인 된 아이디, ProblemNo : 문제번호, inputAns : 입력한 답
	 * @return 실패시 0, 성공시 1
	 */
	
	public int insertError(ErrorVO vo) throws SQLException;
	
	/**
	 * 오답노트 확인  - 문제, 답, 입력한 답, 해설 출력
	 * @return list
	 */
	
	public List<ErrorVO> selectAll() throws SQLException;
	
	/**
	 * 오답노트 삭제 : 미정  
	 * @param
	 * @return list
	
	 	추가여부 미정
		public int DeleteByErrorNo(int ErrorNo);
	*/
	public boolean duplicatedByNo(int qno) throws SQLException;
	
	public int updateError(int qno) throws SQLException;
	
}
