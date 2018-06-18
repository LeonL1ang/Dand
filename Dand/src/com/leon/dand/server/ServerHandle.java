package com.leon.dand.server;
import com.leon.dand.connection.*;
import java.io.*;
import java.net.*;
import java.util.*;
import com.leon.dand.action.*;

public class ServerHandle
{
	
	private ServerSocket ss = null;
	private Integer SERVER_PORT = null;
	private Integer MAX_CONCANT_COUNT = null;
	private static ConnectionPool cp = null;
	private boolean isStart = true;
	private static int count = 0;
	private static DispatchAction dispatchAction = null;
	
	public ServerHandle(DispatchAction dispatchAction){
		this.dispatchAction = dispatchAction;
		this.SERVER_PORT = 7878;
		this.MAX_CONCANT_COUNT = 1000;
		cp = new ConnectionPool();
	}
	
	public ServerHandle(){
		this(7878,1000);
	}
	
	public ServerHandle(Integer serverPort){
		this(serverPort, 1000);
	}
	
	public ServerHandle(Integer serverPort, Integer maxConCount){
		this.SERVER_PORT = serverPort;
		this.MAX_CONCANT_COUNT = maxConCount;
		cp = new ConnectionPool();
	}
	
	public static void deleteCon(Connection con){
		cp.removeConnection(con);
	}
	
	public static void addCon(Connection con){
		cp.addConnection(con);
	}

	public void close(){
		isStart = false;
		if(ss != null){
			try
			{
				ss.close();
			}
			catch (IOException e)
			{e.printStackTrace();}
		}
	}
	
	//启动服务器,ServerSocket获取一个链接socket
	public void start(){
		try
		{
			ss = new ServerSocket(SERVER_PORT);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		while(!ss.isClosed() && ss.isBound()){
			try
			{
				
				Socket s = ss.accept();
				count++;
				System.out.println("链接数:"+count);
				System.out.println("进程数："+Thread.activeCount());
					Connection con = new Connection(s, dispatchAction);
					new Thread(con).start();
					this.addCon(con);
				
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
