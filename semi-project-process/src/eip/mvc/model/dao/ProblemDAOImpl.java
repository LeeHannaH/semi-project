package eip.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import eip.mvc.model.dto.ProblemVO;
import eip.mvc.model.util.DBUtil;

public class ProblemDAOImpl implements ProblemDAO{
	private Properties proFile = DBUtil.getProFile();

	
	@Override
	public int insertProblem(ProblemVO problem) throws SQLException {
		
		Connection con = null;
		PreparedStatement ps = null;
		String sql = proFile.getProperty("problem.insert");
		int result = 0;
		
		try {
			
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, problem.getKind());
			ps.setString(2, problem.getProblem());
			ps.setInt(3, problem.getAnswer());
			ps.setString(4, problem.getExplain());
			ps.setString(5, problem.getKeyword());
			result = ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(ps, con);
		}
		
		
		return result;
	}

	@Override
	public List<ProblemVO> selectAll() throws SQLException {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = proFile.getProperty("problem.selectAll");
		List<ProblemVO> list = new ArrayList<>();
		try{
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new ProblemVO(rs.getInt(1),rs.getString(2),
						rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getDouble(7)));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, ps, con); 
		}
		
		return list;
	}

	@Override
	public int updateProblem(ProblemVO problem) {
		return 0;
	}

	@Override
	public int deleteProblem(int no) {
		return 0;
	}
	
}
