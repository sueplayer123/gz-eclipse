package com.example.gz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class testsql {
	// mysql椹卞姩鍖呭悕
	private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	// 鏁版嵁搴撹繛鎺ュ湴鍧�
	private static final String URL = "jdbc:mysql://localhost:3306/testsql";
	// 鐢ㄦ埛鍚�
	private static final String USER_NAME = "root";
	// 瀵嗙爜
	private static final String PASSWORD = "080716suchao*";

	public static void main(String[] args) {
		Connection connection = null;
		try {
			// 鍔犺浇mysql鐨勯┍鍔ㄧ被
			Class.forName(DRIVER_NAME);
			// 鑾峰彇鏁版嵁搴撹繛鎺�
			connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			// mysql鏌ヨ璇彞
			String sql = "SELECT*  FROM student";
			PreparedStatement prst = connection.prepareStatement(sql);
			// 缁撴灉闆�
			ResultSet rs = prst.executeQuery();
			while (rs.next()) {
				System.out.print(rs.getInt(1));
				System.out.print(rs.getString(2));
				System.out.print(rs.getString(3));
			}
			rs.close();
			prst.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
