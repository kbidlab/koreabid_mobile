package kr.co.koreabid.koreabidapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.content.Intent;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
      //추가 시작
        new Thread(new Runnable(){
        	public void run(){
        		try{
        			Thread.sleep(3000);
        		}
        		catch(Exception e){}
        		startActivity(new Intent(MainActivity.this, PhoneGapActivity.class));
        		finish();
        	}
        }).start();
        //추가 끝
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
