package com.onlinexam.util;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.onlinexam.po.Test;

@SuppressWarnings("unused")
public class DataBaseTest1 {
	private static DBUtil dbUtil;

	public static void main(String[] args) throws Exception {
		String s[] = new String[] {"a","b","c","d"};
		StringBuffer sbBuffer = new StringBuffer();
		for(int i=0; i<s.length;i++) {
			sbBuffer.append(s[i]);
			if(i != s.length - 1) {
				sbBuffer.append(",");
			}
		}
		System.out.println(sbBuffer.toString());
		
	}
		
		
	
}


