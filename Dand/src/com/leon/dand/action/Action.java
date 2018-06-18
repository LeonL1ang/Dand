package com.leon.dand.action;
import com.leon.dand.http.*;


abstract class Action
{
	
		abstract HttpResponse doAction(HttpResponse httpResponse, HttpRequest httpRequest);
	
}
