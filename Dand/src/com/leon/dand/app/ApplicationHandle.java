package com.leon.dand.app;

import com.leon.dand.action.Action;
import java.io.*;
import java.util.*;

public class ApplicationHandle
{
	
	private Long MAX_FILE_BYTE = 1024L * 1024 * 30;
	private String webAppPath = "/storage/emulated/0/AAAAAA/javaCode/Dand/app/src/main/java/";
	private String packagePath = "com/leon/dand/webapp";
	private String appName = null;
	private Map<String, ApplicationFile> appFileMap = new HashMap<String, ApplicationFile>();
	//private MimeTypeMap mimeMap = null;
	
	public ApplicationHandle(String appName){
		this.appName = appName;
		//mimeMap = MimeTypeMap.getSingleton();
	}
	
	public Map<String, ApplicationFile> loadWebApp(){
		
		String path = (webAppPath + packagePath +appName);
		File file = new File(path);
	    loadFile(appName, file);
		return appFileMap;
	}
	
	private void loadFile(String path, File file){
		File[] files = file.listFiles();
		if(files != null){
			for(File f : files){
				if(f.isDirectory()){
					loadFile(path +"/"+ f.getName(), f);
				}else if(file.length() <= MAX_FILE_BYTE){
					mapper(path + "/" + f.getName(), f);
				}else{
				try
				{
					throw new Exception("文件大于设定值：" + MAX_FILE_BYTE);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		}
	}
	
	private void mapper(String path, File file){
		//System.out.println("加载的文件" + file.getName());
		ApplicationFile af = new ApplicationFile();
		byte[] bytes = new byte[Integer.parseInt(file.length() + "")];
		BufferedInputStream bis = null;
		try
		{
			bis = new BufferedInputStream(new FileInputStream(file));
			bis.read(bytes);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		af.setFileBytes(bytes);
		af.setFileLength(bytes.length);
		af.setFileName(file.getName());
		af.setPath(file.getAbsolutePath());
		//System.out.println(path);
		//af.setMime(mimeMap.getMimeTypeFromExtension(file.getName().split("\\.")[1]));
		appFileMap.put(path, af);
		
		}
	
}
