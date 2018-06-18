package com.leon.dand.action;
import com.leon.dand.http.*;
import java.util.*;
import com.leon.dand.app.*;

public class AppFileAction
{
	//private static Map<String, ApplicationFile> appFileMap = null;
	
	public AppFileAction(Map<String, ApplicationFile> appFileMap){
		new FileUtil().initAppFileMime(appFileMap);
	}
	
	public HttpResponse doAction(HttpResponse httpResponse, HttpRequest httpRequest, ApplicationFile af)
	{
	
		httpResponse.setCode(200);
		httpResponse.setCodeInfo("OK");
		httpResponse.setContentMimeType(af.getMime());
		httpResponse.setContentBytes(af.getFileBytes());
		httpResponse.setContentLength(af.getFileLength());
		return httpResponse;
		
	}

	
}
