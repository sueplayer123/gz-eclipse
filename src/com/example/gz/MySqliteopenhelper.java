package com.example.gz;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MySqliteopenhelper extends SQLiteOpenHelper {

	public MySqliteopenhelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, null, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		System.out.println("----------onUpdate---------" + oldVersion + "--------" + newVersion);
	}

}
