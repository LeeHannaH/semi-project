package eip.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import eip.mvc.model.dto.ErrorVO;

public interface ErrorService {
	public int insertError(ErrorVO vo) throws SQLException;
	
	
	public List<ErrorVO> selectAll() throws SQLException;
}
