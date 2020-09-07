package com.example.gz;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class DemoActivity extends Activity {
	private TextView textView1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_demo);
		textView1 = (TextView) findViewById(R.id.textView1);
		Bundle bundle = getIntent().getExtras();
		String dataString2 = bundle.getString("data2");
		textView1.setText(dataString2);
		textView1.setMovementMethod(new ScrollingMovementMethod());
	}
}
