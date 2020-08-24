package com.example.gz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test {

	private static Connection con; // ���� Connection ����
	private static PreparedStatement pStmt;// ����Ԥ���� PreparedStatement ����
	private static ResultSet res;// ������� ResultSet ����

	private static String url = "jdbc:mysql://localhost:3306/testsql";// Э�飺��Э�飺//Ŀ��IP��ַ���˿�/���ݿ� ������test1��֮ǰ���������ݿ���
	private static String user = "root";
	private static String password = "080716suchao*";

	public Connection getConnection() {// ��������ֵΪ Connection �ķ���

		// ����飨1�����������ݿ�������
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("���ݿ��������سɹ�");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// ����飨2����ͨ���������ݿ��URL��ȡ���ݿ����Ӷ���
		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("���ݿ����ӳɹ�");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return con;
	}

	public static void main(String[] args) {// ������
		test c = new test();// �����������
		con = c.getConnection();// �����ݿ⽨������
		queryData();// ��ѯ����
		// addData();//��������
		// updateData();//��������
		// deleteData();//ɾ������
	}

	// ����飨3��������SQL�����в���
	public static void queryData() {

		try { // mysql��ѯ���
			String sql = "SELECT * FROM student";

			// ����飨4�����õ������
			pStmt = con.prepareStatement(sql);
			res = pStmt.executeQuery();

			while (res.next()) {// �����ǰ��䲻�����һ���������ѭ��
				// ����飨5����չʾ���ݼ�

				System.out.println(res.getInt(1));
				System.out.println(res.getString(2));
				System.out.println(res.getString(3));
			}
			res.close();// �ͷ���Դ
			pStmt.close();
		} catch (SQLException e) {// �����쳣
			e.printStackTrace();
		}
	}

	public static void addData() {// ������ݲ���
		try {
			// pStmt = con.prepareStatement

			pStmt = con.prepareStatement("insert into student (id, name, age) values(5,'�ܶ�',46)");
			pStmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void updateData() {// �������ݲ���
		try {
			pStmt = con.prepareStatement("update student set name = '�ճ�' where  id= 1");
			// pStmt.setString(1, "����");ͨ���
			pStmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteData() {// ɾ�����ݲ���
		try {
			Statement stmt = con.createStatement();// ����Statement����
			stmt.executeUpdate("delete from student where id=2");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
