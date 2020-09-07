package com.example.gz;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class CaseActivity extends Activity {
	private TextView textView1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_case);
		textView1 = (TextView) findViewById(R.id.textView1);
		Bundle bundle = getIntent().getExtras();
		String dataString3 = bundle.getString("data3");
		textView1.setText(dataString3);
		textView1.setMovementMethod(new ScrollingMovementMethod());
	}
}
