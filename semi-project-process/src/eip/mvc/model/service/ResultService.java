package eip.mvc.model.service;

import java.util.List;

import eip.mvc.model.dto.ResultVO;

public interface ResultService {
	
	public List<ResultVO> selectAll();

	public int insertResult(ResultVO result);
}
