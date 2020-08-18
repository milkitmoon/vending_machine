package com.milkit.app.util;

import java.nio.charset.Charset;

public class StringUtil {

	public static String convertFixedStr(String src, Charset charset, int fixedLength) throws Exception {
		byte[] fixedBytes = fillSomthingBytes(fixedLength, (byte)0x20);
		
		byte[] srcBytes = null;
		if(src != null) {
			srcBytes = src.getBytes(charset);
		} else {
			srcBytes = new byte[]{};
		}
		
		if(srcBytes.length > fixedBytes.length) {
			throw new Exception("src String bytes길이가 너무 큽니다 !! \n"+"srcBytes legnth:"+srcBytes.length+"	fixedBytes legnth:"+fixedBytes.length);
		}
		
		System.arraycopy(srcBytes, 0, fixedBytes, 0, srcBytes.length);
		
		return new String(fixedBytes, charset);
	}
	
	public static byte[] fillSomthingBytes(int len, byte fillByte) {
        byte[] newBytes = new byte[len];
        
        for(int i = 0 ; i < len; i++) {
        	newBytes[i] = fillByte;
        }
        return newBytes;
	}
}
