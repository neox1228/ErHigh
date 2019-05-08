package com.software.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ��װ��ɾ��ģ��
 * 
 * @author Neo
 * @version ����ʱ�䣺2019��5��6�� ����9:34:14
 */
public class JDBCTemplate {

	/**
	 * ��װ�ĸ���ģ��
	 * 
	 * @param sql
	 *            SQL���
	 * @param setter
	 *            �Ƿ���Ҫ��SQL��������ֵ
	 * @return (int)row ������Ӱ�������
	 * @throws SQLException
	 */
	public int update(String sql, PreperedStatmentSetter setter) throws SQLException {

		// ʹ��ConnectFactory�࣬����getConnection()���������ݿ��������������ݿ�
		Connection conn = ConnectFactory.getConnection();

		// �������SQL��䴫�����ݿ���
		PreparedStatement pstmt = conn.prepareStatement(sql);

		/*
		 * ��Ϊ������Ҫ����֮����Ҫ �ж�SQL���Ƿ���Ҫ����ֵ
		 */
		if (setter != null) {
			setter.setvalues(pstmt);
		}

		// ����SQL���
		int row = pstmt.executeUpdate();

		// �ر���Դ
		DBUtil.close(pstmt, conn);

		// ����ֵ
		return row;
	}

	/**
	 * ��װ�Ĳ�ѯģ��
	 * 
	 * @param sql
	 *            SQL���
	 * @param setter
	 *            �Ƿ���Ҫ��SQL��������ֵ
	 * @param handler
	 *            �Ƿ���Ҫ�Բ����ķ���ֵ���д���
	 * @throws SQLException
	 */
	public void query(String sql, PreperedStatmentSetter setter, ResultSetHandler handler) throws SQLException {

		// ʹ��ConnectFactory�࣬����getConnection()���������ݿ��������������ݿ�
		Connection conn = ConnectFactory.getConnection();

		// �������SQL��䴫�����ݿ���
		PreparedStatement pstmt = conn.prepareStatement(sql);

		/*
		 * ��Ϊ������Ҫ����֮����Ҫ �ж�SQL���Ƿ���Ҫ����ֵ
		 */
		if (setter != null) {
			setter.setvalues(pstmt);
		}

		// ����SQL���
		ResultSet rs = pstmt.executeQuery();

		/*
		 * ֵΪ�գ�����Ҫ����֮��Ȼ�� �жϷ���ֵ�Ƿ���Ҫ����
		 */
		if (handler != null) {
			handler.handlerRs(rs);
		}

		// �ر���Դ
		DBUtil.close(rs, pstmt, conn);
	}

}
