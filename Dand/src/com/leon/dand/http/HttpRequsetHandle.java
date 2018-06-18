package com.leon.dand.http;
import java.io.*;
import java.util.*;

public class HttpRequsetHandle
{
	private static String CRLF = "\r\n";
	
	// GET / HTTP/1.1
	//Host: 127.0.0.1:7878
	//Connection: keep-alive
	//Cache-Control: max-age=0
	//Upgrade-Insecure-Requests: 1
	//User-Agent: Mozilla/5.0 (Linux; Android 5.1.1; vivo X7 Build/LMY47V) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.109 Mobile Safari/537.36
	//Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8
	//Accept-Encoding: gzip, deflate, br
	//Accept-Language: zh-CN,zh;q=0.9^  
	// ^

	public static HttpRequest parseHeader(String header, HttpRequest httpRequest){
	 	
		String[] str = header.split(CRLF);
		String[] firstLine = str[0].split(" ");
		System.out.println(firstLine.length);
		if(firstLine.length == 3){
			httpRequest.setMethod(firstLine[0]);
			httpRequest.setRequestURL(firstLine[1]);
			httpRequest.setRequestURI(firstLine[2]);
		}
		Map<String, String> headerMap = new HashMap<String, String>();
		
		for(int i = 1;i<str.length;i++){
			String[] line = str[i].split(":");
			headerMap.put(line[0], line[1]);
		}
		
		httpRequest.setAccept(headerMap.get("Accept"));
		httpRequest.setAgent(headerMap.get("Agent"));
		httpRequest.setCharset(headerMap.get("Accept-Charset"));
		httpRequest.setConnection(headerMap.get("Connection"));
		httpRequest.setEncoding(headerMap.get("Accept-Encoding"));
		httpRequest.setHost(headerMap.get("Host"));
		httpRequest.setLanguage(headerMap.get("Accept-Language"));
		String length= null;
		if((length = headerMap.get("Content-Length")) != null){
			httpRequest.setContentLength(Integer.parseInt(length));
		}else{
			httpRequest.setContentLength(0);
		}
		
		return httpRequest;
	}
	
	public static void mapperRequest(HttpRequest httpRequest, Map<String, File> appFileMap){
		
		StringBuilder sb = new StringBuilder();
		
		if(httpRequest.getMethod().equals("GET")){
			File file = appFileMap.get(httpRequest.getRequestURL());
			
		}
		
	}
	
}
