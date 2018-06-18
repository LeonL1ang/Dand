package com.leon.dand.http;

import java.io.*;
import java.util.*;
import java.nio.*;
import com.leon.dand.app.*;

public class HttpResponseHandle
{
	
	private static String BLANK = " ";
	private static String CRLF = "\r\n";
	private static String CHAR_SET = "UTF-8";
	
	public static byte[] build(int code, ApplicationFile af){
		StringBuilder response = new StringBuilder();
		
		byte[] bytes = null;
		if(code == 200 && af != null){
			
			String conType = "text/html";

			if(af.getFileName().endsWith("css")){
				conType = "text/css";
			}else if(af.getFileName().endsWith("js")){
				conType = "application/javascript";
			}else if(af.getFileName().endsWith("jpg")){
				conType = "image/jpeg";
			}
			//1)  HTTP协议版本、状态代码、描述
			response.append("HTTP/1.0").append(BLANK).append(code).append(BLANK).append("OK").append(CRLF);
//2)  响应头(Response Head)
			response.append("Connection: ").append("close").append(CRLF);
			response.append("Server: Dand/1.0").append(CRLF);
			response.append("Date: ").append(new Date()).append(CRLF);
			response.append("Content-Type: " + conType).append(CRLF);
			//正文长度 ：字节长度
		    response.append("Content-Length: ").append(af.getFileBytes().length).append(CRLF);
			//3)正文之前
			response.append(CRLF);
			//4)正文
			System.out.println("返回：");
			System.out.println(response.toString());
			bytes = new byte[response.length() + af.getFileLength()];
			System.arraycopy(response.toString().getBytes(), 0, bytes, 0, response.length());
			System.arraycopy(af.getFileBytes(), 0, bytes, response.length(), af.getFileLength());
		 
		}else if(code == 404){
			response.append("HTTP/1.0").append(BLANK).append(code).append(BLANK).append("Not Found").append(CRLF);
//2)  响应头(Response Head)

			response.append("Connection:").append("close").append(CRLF);
			response.append("Server:Dand/1.0").append(CRLF);
			response.append(CRLF);
			System.out.println("返回：");
			System.out.println(response.toString());
			bytes = response.toString().getBytes();
			
		}
		
		return bytes;
	}
	
	public static String buildToByte(HttpResponse httpResponse){
		String str = null;
		System.out.println("第一次");
		if(httpResponse.getCode().equals(200)){
			
			str = httpResponse.getHttpVersion() + BLANK + httpResponse.getCode() + BLANK + httpResponse.getCodeInfo() + CRLF
			+ "Connection: close" + CRLF 
			+ "Server: " + httpResponse.getServerId() + CRLF
			+ "Date: " + new Date() + CRLF
			+ "Content-Type: " + httpResponse.getContentMimeType() + CRLF
			+ "Content-Length: " + httpResponse.getContentLength() + CRLF
			+ CRLF;
		}else if(httpResponse.getCode().equals(404)){
			str = httpResponse.getHttpVersion() + BLANK + httpResponse.getCode() + BLANK + httpResponse.getCodeInfo() + CRLF
				+ "Connection: close" + CRLF 
				+ "Server: " + httpResponse.getServerId() + CRLF
				+ "Date: " + new Date() + CRLF
				+ CRLF;
		}
		System.out.println("返回头:" + str);
		return str;
	}

}
