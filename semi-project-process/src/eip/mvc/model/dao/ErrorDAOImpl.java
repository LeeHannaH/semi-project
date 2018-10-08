package eip.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import eip.mvc.model.dto.ErrorVO;
import eip.mvc.model.util.DBUtil;

public class ErrorDAOImpl implements ErrorDAO{
	private Properties proFile = DBUtil.getProFile();

	@Override
	public int insertError(ErrorVO vo) throws SQLException {
		//이제 vo(틀린문제)를 db에 넣어줘야 함
		Connection con = null;
		PreparedStatement ps = null;
		String sql = proFile.getProperty("error.insert");
		int result = 0;
		
		try {
			
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getProblem().getNo());
			ps.setString(2, vo.getId());
			ps.setInt(3, vo.getErrorAnswer());
			ps.setInt(4, 0);
			result = ps.executeUpdate();

			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(ps, con);
		}
		
		
		return result;
	}

	@Override
	public List<ErrorVO> selectAll() throws SQLException {
		return null;
	}

	@Override
	public boolean duplicatedByNo(int qno) {
		Connection con = null;
		PreparedStatement ps  = null;
		ResultSet rs = null;
		String sql = proFile.getProperty("error.duplicatedByNo");
		boolean result = false;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, qno);
			rs = ps.executeQuery();
			result = rs.next();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, ps, con);
		}
		
		System.out.println("아래 " + result);
		return result;
	}

	@Override
	public int updateError(int qno) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = proFile.getProperty("error.update");
		int result = 0;
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, qno);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(ps, con);
		}
		
		return result;
	}
	
	
	
}
