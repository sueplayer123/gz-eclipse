package com.example.test;

import android.test.AndroidTestCase;

public class TestMyService extends AndroidTestCase {
	public void testAdd() throws Exception {
		MyService myService = new MyService();
		int retVal = myService.add(3, 5);
		// 断言，预期结果是8，实际结果是retVal
		assertEquals(8, retVal);
	}
}
