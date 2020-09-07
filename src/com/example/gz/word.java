package com.example.gz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;

public class word {
	public static void main(String[] args) {

		readWord2003("变电站典型故障诊断与处理流程手册2020.7.20.doc");

	}

	public static String readWord2003(String filePath) {
		FileInputStream fis;
		HWPFDocument doc;
		String text = null;
		try {
			File f = new File(filePath);
			fis = new FileInputStream(f);
			doc = new HWPFDocument(fis);
			Range rang = doc.getRange();
			text = rang.text();

			System.out.println(text);

			fis.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return text;
	}
}
