package com.example.test;

import android.test.AndroidTestCase;

public class TestMyService extends AndroidTestCase {
	public void testAdd() throws Exception {
		MyService myService = new MyService();
		int retVal = myService.add(3, 5);
		// ���ԣ�Ԥ�ڽ����8��ʵ�ʽ����retVal
		assertEquals(8, retVal);
	}
}
