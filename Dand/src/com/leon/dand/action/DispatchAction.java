package com.leon.dand.action;
import com.leon.dand.http.*;
import java.util.*;
import com.leon.dand.app.*;
import java.lang.reflect.*;

public class DispatchAction
{
	
	private static AppFileAction appFileAction = null;
	private static Map<String, ApplicationFile> appFileMap = null;
	private static Map<String, Method> actionMethodMap = null;
	
	public DispatchAction(Map<String, ApplicationFile> appFileMap){
		this.appFileMap = appFileMap;
		appFileAction = new AppFileAction(appFileMap);
	}
	
	public static HttpResponse dispatch(HttpRequest httpRequest, HttpResponse httpResponse){
		
		String meth = httpRequest.getMethod();
		String requestUrl = httpRequest.getRequestURL();
		
		if(meth != null){
			if(meth.equals("GET")){

				ApplicationFile af = appFileMap.get(requestUrl);

				if(af == null){
					httpResponse.setCode(404);
					httpResponse.setCodeInfo("Not Found");
				}else{
					httpResponse =  appFileAction.doAction(httpResponse, httpRequest, af);
				}
			}else{
				Method method = actionMethodMap.get(meth + ":" + requestUrl);
				//httpResponse = appFileAction.doAction(httpResponse, httpRequest);
			}
		}
		
		
		return httpResponse;
	}
	
	private HttpResponse getNotFount(HttpResponse httpResponse){
		return null;
	}
}
