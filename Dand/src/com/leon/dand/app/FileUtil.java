package com.leon.dand.app;

import java.util.*;
import android.webkit.*;

public class FileUtil
{
	
	public FileUtil(){
		super();
	}

	public void initAppFileMime(Map<String, ApplicationFile> appFileMap)
	{
		Map<String, String> mimeMap = getMyMimeTypeMap();
		String mime = null;
		for(ApplicationFile af : appFileMap.values()){
			String[] str = af.getFileName().split("\\.");
			if(str == null){
				af.setMime("application/octet-stream");
			}else{
				mime = mimeMap.get(str[str.length - 1]);
				if(mime == null){
					af.setMime("application/octet-stream");
				}else{
					af.setMime(mime);
				}
			}
		}
	}
	
	
	//方式1根据文件后缀获得文件mime类型
	public String getFileMineType(String endStr, Map<String, String> mimeTypeMap){
		String str = mimeTypeMap.get(endStr);
		if(str == null)str = "";
		return str;
	}

	public Map<String, String> getMyMimeTypeMap(){
		Map<String, String> MimeTypeMap = new HashMap<String, String>();
		MimeTypeMap.put("text","text/plain");
		MimeTypeMap.put("gif","image/gif");
		MimeTypeMap.put("jpeg","image/jpeg");
		MimeTypeMap.put("jpg","image/jpeg");
		MimeTypeMap.put("html"," text/html");
		MimeTypeMap.put("css","text/css");
		MimeTypeMap.put("js","application/javascript");
		MimeTypeMap.put("pdf","application/pdf");
		MimeTypeMap.put("doc", "application/msword");
		return MimeTypeMap;
	}
	
	//方式二 用android.webkit.MimeTypeMap判断后缀返回mime
	public String getMimeType(String endStr,MimeTypeMap mtm){
		return mtm.getMimeTypeFromExtension(endStr);
	}
	
	public MimeTypeMap getMimeTypeMap(){
		return MimeTypeMap.getSingleton();
	}
}
