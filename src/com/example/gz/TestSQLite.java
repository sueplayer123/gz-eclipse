package com.example.gz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSQLite {
	public static void main(String[] args) {
		// new TestSQLite().save();
		// new TestSQLite().del();
		// new TestSQLite().update();
		// new TestSQLite().queryByName();
		// new TestSQLite().queryAll();
		new TestSQLite().createTable();
	}

	protected static Connection connect = null;
	protected static Statement stmt = null;
	static {
		try {
			Class.forName("org.sqlite.JDBC");
			connect = DriverManager.getConnection("jdbc:sqlite://C:/Users/sue/test123.db");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Opened database successfully");
	}

	public void createTable() {
		try {
			connect.setAutoCommit(false);

			stmt = connect.createStatement();

			String sql = "create table user(id int,name text,sex text)";

			stmt.executeUpdate(sql);
			System.out.println("create data success");

			// �ύ
			connect.commit();

			// �ر�Statement
			stmt.close();
			connect.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void save() {
		try {
			connect.setAutoCommit(false);

			stmt = connect.createStatement();

			String sql = "insert into test_t(id,value) values(2,'tom')";

			// ִ��
			int count = stmt.executeUpdate(sql);
			if (count > 0) {
				System.out.println("insert data success");
			} else {
				System.out.println("insert data fail");
			}

			// �ύ
			connect.commit();

			sql = "select * from test_t";

			ResultSet result = stmt.executeQuery(sql);
			while (result.next()) {
				System.out.println(result.getInt("id"));
				System.out.println(result.getString("value"));
			}

			result.close();

			// �ر�Statement
			stmt.close();
			// �ر�Connection
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void queryAll() {
		try {
			connect.setAutoCommit(false);
			stmt = connect.createStatement();

			String sql = "select * from test_t";

			ResultSet result = stmt.executeQuery(sql);
			while (result.next()) {
				System.out.println(result.getInt("id"));
				System.out.println(result.getString("value"));
			}

			result.close();
			stmt.close();
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void queryByName() {
		try {
			connect.setAutoCommit(false);
			stmt = connect.createStatement();

			String sql = "select * from test_t where value = 'tom'";

			ResultSet result = stmt.executeQuery(sql);
			while (result.next()) {
				System.out.println(result.getInt("id"));
				System.out.println(result.getString("value"));
			}

			result.close();
			stmt.close();
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update() {
		try {
			connect.setAutoCommit(false);
			stmt = connect.createStatement();

			String sql = "update  test_t  set value = 'xiaoli' where id = 3";
			int count = stmt.executeUpdate(sql);

			if (count > 0) {
				System.out.println("update data success");
			} else {
				System.out.println("update data fail");
			}
			connect.commit();

			String querySql = "select * from test_t";
			ResultSet result = stmt.executeQuery(querySql);
			while (result.next()) {
				System.out.println(result.getInt("id"));
				System.out.println(result.getString("value"));
			}

			result.close();
			stmt.close();
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void del() {
		try {
			connect.setAutoCommit(false);
			stmt = connect.createStatement();

			String sql = "delete from test_t where id = 2";
			int count = stmt.executeUpdate(sql);

			if (count > 0) {
				System.out.println("delete data success");
			} else {
				System.out.println("delete data fail");
			}

			connect.commit();

			String querySql = "select * from test_t";
			ResultSet result = stmt.executeQuery(querySql);
			while (result.next()) {
				System.out.println(result.getInt("id"));
				System.out.println(result.getString("value"));
			}

			result.close();
			stmt.close();
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
