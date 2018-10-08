package eip.mvc.model.dao;

import java.sql.SQLException;

import eip.mvc.model.dto.User;

public interface LoginDAO {

	/**
	 * ��������
	 * @param id: �Է��� ���̵�, password : ��й�ȣ
	 * @return ���н� 0, ������ 1
	 */
	public int insertAccount(String id, String pwd) throws SQLException;
	
	/**
	 * �α���
	 * @param id: ���̵�, password : ��й�ȣ
	 * @return ������ true, ���� false;//??????????????????????????????????????????????
	 */
	public User selectByIdPwd(String id, String pwd) throws SQLException;
	//1. �α��ΰ��� �������� ���
	//2. �Ŵ������� �������� ���
}