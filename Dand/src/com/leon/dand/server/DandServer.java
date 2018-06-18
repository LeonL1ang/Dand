package com.leon.dand.server;

import com.leon.dand.action.Action;
import com.leon.dand.app.*;
import java.util.*;
import com.leon.dand.action.*;

public class DandServer
{

	private ServerHandle sh = null;
	
	public DandServer(){
		ApplicationHandle appHandle = new ApplicationHandle("/leonblog");
		DispatchAction dispatchAction = new DispatchAction(appHandle.loadWebApp());
		sh = new ServerHandle(dispatchAction);
	}

	public void closeServer()
	{
		sh.close();
	}

	public void startServer(){
		sh.start();
	}
	
}
