package com.leon.dand.action;
import com.leon.dand.http.*;
import java.lang.reflect.*;

public class ApplicationAction
{
	
	public void doAction(HttpRequest httpRequest, HttpResponse httpResponse, Method method){
		
		before();
		method.invoke();
		after();
		
	}
	
	public void before(){
		
	}
	
	public void after(){
		
	}
	
}
