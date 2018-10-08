package eip.mvc.model.dao;

import java.util.List;

import eip.mvc.model.dto.ResultVO;

public interface ResultDAO {
	
	/**
	 * @return : List<Result> 결과조회 
	 */
	public List<ResultVO> selectAll();

	
	/**
	 * @Param : Result - 채점 계산해서 삽입
	 * @return : int  결과값 리턴
	 */
	public int insertResult(ResultVO result);
	
}
