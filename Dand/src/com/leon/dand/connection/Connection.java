package com.leon.dand.connection;

import com.leon.dand.app.*;
import com.leon.dand.http.*;
import com.leon.dand.server.*;
import java.io.*;
import java.net.*;
import com.leon.dand.action.*;

public class Connection implements Runnable
{
	
	private Socket socket;

	private BufferedOutputStream bos = null;
	private BufferedInputStream bis = null;
	private DispatchAction dispatchAction =null;
	
	public Connection(Socket s, DispatchAction dispatchAction){
		
		this.socket = s;
		this.dispatchAction = dispatchAction;
		
	}

	public void close()
	{
		if(socket != null){
			try
			{
				socket.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}finally{
				ServerHandle.deleteCon(this);
			}
		}
	}
	
	//启动一个http请求的socket链接
	@Override
	public void run()
	{
		
		try
		{
			//bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bos = new BufferedOutputStream(socket.getOutputStream());
			//br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bis = new BufferedInputStream(socket.getInputStream());
			HttpRequest httpRequest = receiveByte();
			System.out.println("请求方式"+httpRequest.getRequestURL());
			HttpResponse httpResponse = new HttpResponse("Dand 1.0","HTTP/1.0");
			
			httpResponse = dispatchAction.dispatch(httpRequest, httpResponse);
			
			send(HttpResponseHandle.buildToByte(httpResponse), httpResponse.getContentBytes());
		
			
		}
		catch (IOException e)
		{
			ServerHandle.deleteCon(this);
			e.printStackTrace();
		}finally{
			
		}
		
	}

		//读取客户端发送的请
		private HttpRequest receiveByte(){
		
			HttpRequest hr = new HttpRequest();
			ByteArrayOutputStream swapStream = new ByteArrayOutputStream(); 
			byte[] bytes =  new byte[50];
			int length = -1;
			try
			{
				while ((length = bis.read(bytes, 0, 50)) != -1)
				{
		
					swapStream.write(bytes, 0, length);
					if(length < 50)break;
				}
			}
			catch (IOException e)
			{e.printStackTrace();}
			
			HttpRequsetHandle.parseHeader(swapStream.toString(), hr);
			
			return hr;
		}
		
		private void send(String header, byte[] bytes){
			
			try
			{
				System.out.println("发送:");
				bos.write(header.getBytes());
				if(bytes != null){
					bos.write(bytes);
				}
				System.out.println(header);
				bos.flush();
				bis.close();
				bos.close();
				socket.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}

		}
		
}
