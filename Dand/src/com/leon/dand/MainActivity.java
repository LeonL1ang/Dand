package com.leon.dand;

import android.app.*;
import android.content.*;
import android.os.*;
import com.leon.dand.server.*;
import android.widget.*;
import android.view.*;
import android.util.*;

public class MainActivity extends Activity 
{
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
		
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		Button dandButton = (Button) findViewById(R.id.dandServer);
		final TextView info = (TextView) findViewById(R.id.textInfo);
		dandButton.setOnClickListener(new View.OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
					
					//Intent intent = new Intent(MainActivity.this, DandServer.class);
					//startService(intent);
					new Thread(new Runnable(){

							@Override
							public void run()
							{
								// TODO: Implement this method
								Intent intent = new Intent();
								intent.setClass(MainActivity.this, DandActivity.class); //设置跳转的Activity  
								startActivity(intent);  
							}
							
						
					}).start();
				}
				
			
		});
    }
	
	
	
}
