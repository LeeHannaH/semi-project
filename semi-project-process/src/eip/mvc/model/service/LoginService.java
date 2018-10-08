package eip.mvc.model.service;

import java.sql.SQLException;

import eip.mvc.model.dto.User;

public interface LoginService {
	
	public int insertAccount(String id, String pwd) throws SQLException;

	public User selectByIdPwd(String id, String pwd) throws SQLException;
}
