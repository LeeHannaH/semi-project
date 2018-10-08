package eip.mvc.model.dao;

import java.sql.SQLException;

import eip.mvc.model.dto.User;

public interface LoginDAO {

	/**
	 * 계정생성
	 * @param id: 입력한 아이디, password : 비밀번호
	 * @return 실패시 0, 성공시 1
	 */
	public int insertAccount(String id, String pwd) throws SQLException;
	
	/**
	 * 로그인
	 * @param id: 아이디, password : 비밀번호
	 * @return 성공시 true, 실패 false;//??????????????????????????????????????????????
	 */
	public User selectByIdPwd(String id, String pwd) throws SQLException;
	//1. 로그인값을 가져오는 경우
	//2. 매니저값을 가져오는 경우
}
