package com.leon.dand;
import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import com.leon.dand.server.*;
import com.leon.dand.app.*;
import java.util.*;
import java.io.*;
import android.test.*;

public class DandActivity extends Activity
{

	private boolean isStart = false;
	private DandServer dandServer = null;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dand_layout);
		
		Button b1 = (Button) findViewById(R.id.button1);
		final TextView infoText = (TextView) findViewById(R.id.textInfo);
		b1.setOnClickListener(new View.OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					if(isStart){
						Toast.makeText(getApplicationContext(), "服务已启动",
									   Toast.LENGTH_SHORT).show();
					
					}else{
						if(dandServer == null){
							dandServer = new DandServer();
						}
						Toast.makeText(getApplicationContext(), "开启服务",
									   Toast.LENGTH_SHORT).show();
						startDand();
					
					}
				}
				
			
		});
		Button b2 = (Button) findViewById(R.id.button2);
		b2.setOnClickListener(new View.OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
					dandServer.closeServer();
					isStart = false;
					Toast.makeText(getApplicationContext(), "关闭服务",
								   Toast.LENGTH_SHORT).show();
				}
			
		});
		

	}
	public void startDand(){
		new Thread(new Runnable(){

			
			
				@Override
				public void run()
				{
					isStart = true;
					dandServer.startServer();
					
				}
				
			
		}).start();
	}
}
