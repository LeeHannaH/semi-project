package eip.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import eip.mvc.model.dto.User;
import eip.mvc.model.util.DBUtil;

public class LoginDAOImpl implements LoginDAO{
	private Properties proFile = DBUtil.getProFile();

	
	@Override
	public int insertAccount(String id, String pwd) throws SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		String sql = proFile.getProperty("login.insert");
		int result = 0;
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pwd);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(ps, con);
		}
		
		
		return result;
	}

	@Override
	public User selectByIdPwd(String id, String pwd) throws SQLException{

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		String sql = proFile.getProperty("login.selectByIdPwd");

		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			
			if(rs.next())
				user = new User(rs.getString("userid"),rs.getString("manager"));
			
		} catch (Exception e) {
			e.getMessage();
		} finally {
			DBUtil.dbClose(rs, ps, con);
		}
				
		return user;
	}

	
}
