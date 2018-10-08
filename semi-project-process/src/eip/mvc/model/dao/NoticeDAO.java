package eip.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import eip.mvc.model.dto.NoticeVO;

public interface NoticeDAO {

	/**
	 * 공지사항 추가 (관리자 계정인지 확인 후 삽입)
	 * @param : Notice
	 * @return : 0 : 실패, 1 : 성공
	 * */
	public int insertNotice(NoticeVO notice) throws SQLException;
	
	/**
	 * 공지사항 확인 (모든계정)
	 * @return : List<Notice>
	 * */
	public List<NoticeVO> selectAll() throws SQLException;
}
