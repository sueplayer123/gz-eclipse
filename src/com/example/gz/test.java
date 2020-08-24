package com.example.gz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test {

	private static Connection con; // 声明 Connection 对象
	private static PreparedStatement pStmt;// 声明预处理 PreparedStatement 对象
	private static ResultSet res;// 声明结果 ResultSet 对象

	private static String url = "jdbc:mysql://localhost:3306/testsql";// 协议：子协议：//目标IP地址：端口/数据库 在这里test1是之前创建的数据库名
	private static String user = "root";
	private static String password = "080716suchao*";

	public Connection getConnection() {// 建立返回值为 Connection 的方法

		// 代码块（1）：加载数据库驱动类
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("数据库驱动加载成功");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 代码块（2）：通过访问数据库的URL获取数据库连接对象
		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("数据库连接成功");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return con;
	}

	public static void main(String[] args) {// 主方法
		test c = new test();// 创建本类对象
		con = c.getConnection();// 与数据库建立连接
		queryData();// 查询数据
		// addData();//增添数据
		// updateData();//更新数据
		// deleteData();//删除数据
	}

	// 代码块（3）：运用SQL语句进行操作
	public static void queryData() {

		try { // mysql查询语句
			String sql = "SELECT * FROM student";

			// 代码块（4）：得到结果集
			pStmt = con.prepareStatement(sql);
			res = pStmt.executeQuery();

			while (res.next()) {// 如果当前语句不是最后一条，则进入循环
				// 代码块（5）：展示数据集

				System.out.println(res.getInt(1));
				System.out.println(res.getString(2));
				System.out.println(res.getString(3));
			}
			res.close();// 释放资源
			pStmt.close();
		} catch (SQLException e) {// 捕获异常
			e.printStackTrace();
		}
	}

	public static void addData() {// 添加数据操作
		try {
			// pStmt = con.prepareStatement

			pStmt = con.prepareStatement("insert into student (id, name, age) values(5,'熊二',46)");
			pStmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void updateData() {// 更新数据操作
		try {
			pStmt = con.prepareStatement("update student set name = '苏超' where  id= 1");
			// pStmt.setString(1, "周礼");通配符
			pStmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteData() {// 删除数据操作
		try {
			Statement stmt = con.createStatement();// 创建Statement对象
			stmt.executeUpdate("delete from student where id=2");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
