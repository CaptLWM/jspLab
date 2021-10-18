package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import guestbook.dao.MessageDao;
import guestbook.model.Message;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class WriteMessageService {
	private static WriteMessageService instance = new WriteMessageService();

	public static WriteMessageService getInstance() {
		return instance;
	}

	private WriteMessageService() {
	}

	public void write(Message message) {
		Connection conn = null;
		try {
			// 커넥션풀(gusetbook)에서 connection을 하나 가져온다.
			conn = ConnectionProvider.getConnection();
			MessageDao messageDao = MessageDao.getInstance();
			messageDao.insert(conn, message);
		} catch (SQLException e) {
			throw new ServiceException(
					"메시지 등록 실패: " + e.getMessage(), e);
		} finally {
			/*
			 * if(conn!=null) { try { conn.close(); } catch(Exception e) { } }
			 */ //간단하게 작성 가능
			JdbcUtil.close(conn);
		}
	}

}