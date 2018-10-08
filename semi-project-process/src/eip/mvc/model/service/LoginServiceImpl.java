package eip.mvc.model.service;

import java.sql.SQLException;

import eip.mvc.model.dao.LoginDAO;
import eip.mvc.model.dao.LoginDAOImpl;
import eip.mvc.model.dto.User;

public class LoginServiceImpl implements LoginService{
	private LoginDAO dao= new LoginDAOImpl();
	
	@Override
	public int insertAccount(String id, String pwd) throws SQLException {
		int result = dao.insertAccount(id, pwd);
		
		if(result == 0) {
			throw new SQLException("���Կ� �����Ͽ����ϴ�.");
		}
		
		return result; 
	}

	@Override
	public User selectByIdPwd(String id, String pwd) throws SQLException {
		User user = dao.selectByIdPwd(id, pwd);
		
		if(user == null) {
			throw new SQLException("�α��ο� �����Ͽ����ϴ�");
		}
		
		return user;
	}
	
	
}
