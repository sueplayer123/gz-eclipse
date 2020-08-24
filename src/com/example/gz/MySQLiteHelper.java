package com.example.gz;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteHelper extends SQLiteOpenHelper {

	��������public MySQLiteHelper(Context context, String name, CursorFactory factory, int version) {
������������super(context, "test123.db", null, 1);
��������}

	��������@Override
��������public void onCreate(SQLiteDatabase db) {
����������������String sql = "create table student (_id integer primary key,
����������������������������name varchar(20), age integer);";
����������������db.execSQL(sql);
��������}

	������

	��������// ���ݿ�汾����
	��������// �汾��Ҫ�����仯�����򲻻�ִ��
	��������@Override
��������public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
������������Log.d("============", oldVersion + " : " + newVersion);
������������if(oldVersion == 1)
������������{
����������������String sql = "alter table student add version integer;";
����������������db.execSQL(sql);
������������}
��������}

	��������// ÿ�δ����ݿ��ʱ�����
	��������@Override
��������public void onOpen(SQLiteDatabase db) {
����������������super.onOpen(db);
��������}

}
