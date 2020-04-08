package com.havenliu.document;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class Main {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		// DocumentHandler dh=new DocumentHandler();
		// dh.createDoc();
		// MyTest mt=new MyTest();
		// mt.createDoc();

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("name", "你好邱林和");

		MDoc mdoc = new MDoc();
		mdoc.createDoc(dataMap, "D:/outFile1.doc");
		System.out.println("模板生成成功");
	}

}
