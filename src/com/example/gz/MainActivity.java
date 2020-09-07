package com.example.gz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView textView2;
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	private EditText editText1;

	private static String stString1;
	private static String stString2;
	private static String stString3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		textView2 = (TextView) findViewById(R.id.textView2);
		button1 = (Button) this.findViewById(R.id.button1);
		button2 = (Button) this.findViewById(R.id.button2);
		button3 = (Button) this.findViewById(R.id.button3);
		button4 = (Button) this.findViewById(R.id.button4);
		editText1 = (EditText) this.findViewById(R.id.editText1);

		final String DATABASE_PATH = "data/data/" + this.getPackageName() + "/databases/";
		String databaseFile = DATABASE_PATH + "testsc123.db";
		getData();
		final SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(databaseFile, null);

		button1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				InputStream inputStream = getResources().openRawResource(R.raw.sue);
				String string = getString(inputStream);
				textView2.setText(string);
				textView2.setMovementMethod(new ScrollingMovementMethod());

			}
		});
		button2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String sql = "select * from liucheng where liucheng like ?";

				Cursor cursor = db.rawQuery(sql, new String[] { "%" + editText1.getText().toString() + "%" });
				while (cursor.moveToNext()) {

					stString1 = cursor.getString(cursor.getColumnIndex("liucheng"));
				}
				cursor.close();
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, LiuchengActivity.class);
				intent.putExtra("data1", stString1);
				startActivity(intent);

			}
		});
		button3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String sql = "select * from guzhang where name like ?";

				Cursor cursor = db.rawQuery(sql, new String[] { "%" + editText1.getText().toString() + "%" });
				while (cursor.moveToNext()) {

					stString2 = cursor.getString(cursor.getColumnIndex("gzcl"));
				}
				cursor.close();
				Intent intent2 = new Intent();
				intent2.setClass(MainActivity.this, DemoActivity.class);
				intent2.putExtra("data2", stString2);
				startActivity(intent2);

			}
		});
		button4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				Cursor c = db.query(true, "case", new String[] { "id", "case", "content" }, "case like ?",
						new String[] { "%" + editText1.getText().toString() + "%" }, null, null, null, null);

				while (c.moveToNext()) {

					stString3 = c.getString(c.getColumnIndex("content"));
				}
				c.close();
				Intent intent3 = new Intent();
				intent3.setClass(MainActivity.this, CaseActivity.class);
				intent3.putExtra("data3", stString3);
				startActivity(intent3);

			}
		});
	}

	private void getData() {
		final String DATABASE_PATH = "data/data/" + this.getPackageName() + "/databases/";
		String databaseFile = DATABASE_PATH + "testsc123.db";
		// 创建databases目录（不存在时）
		File file = new File(DATABASE_PATH);
		if (!file.exists()) {
			file.mkdirs();
		}
		// 判断数据库是否存在
		if (!new File(databaseFile).exists()) {
			// 把数据库拷贝到/data/data/<package_name>/databases目录下
			try {
				FileOutputStream fileOutputStream = new FileOutputStream(databaseFile);
				// 数据库放assets目录下
				InputStream inputStream = getResources().getAssets().open("testsc123.db");

				byte[] buffer = new byte[1024];
				int readBytes = 0;

				while ((readBytes = inputStream.read(buffer)) != -1)
					fileOutputStream.write(buffer, 0, readBytes);

				inputStream.close();
				fileOutputStream.close();
			} catch (IOException e) {
			}
		}

	}

	public static String getString(InputStream inputStream) {
		InputStreamReader inputStreamReader = null;
		try {
			inputStreamReader = new InputStreamReader(inputStream, "gbk");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		BufferedReader reader = new BufferedReader(inputStreamReader);
		StringBuffer sb = new StringBuffer("");
		String line;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line);
				sb.append("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}
