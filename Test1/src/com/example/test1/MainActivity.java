package com.example.test1;

import java.util.Timer;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;
import android.widget.EditText;
import android.widget.SeekBar;




public class MainActivity extends Activity {

	EditText ed1 = null;
	EditText ed2 = null;
	EditText ed3 = null;
	EditText ed4 = null;
	
	SeekBar sb1 = null ;
	SeekBar sb2 = null;
	SeekBar sb3 = null;
	SeekBar sb4 = null;
	
	
	Handler mHandler = new Handler();
	
	long startTime = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		sb1 = (SeekBar)findViewById(R.id.seekBar1);
		sb2 = (SeekBar)findViewById(R.id.seekBar2);
		sb3 = (SeekBar)findViewById(R.id.seekBar3);
		sb4 = (SeekBar)findViewById(R.id.seekBar4);
		
		ed1 = (EditText)findViewById(R.id.editText1);
		ed2 = (EditText)findViewById(R.id.editText2);
		ed3 = (EditText)findViewById(R.id.editText3);
		ed4 = (EditText)findViewById(R.id.editText4);
		
		ed1.setEnabled(false);
		ed1.setKeyListener(null);
		

		ed2.setEnabled(false);
		ed2.setKeyListener(null);
		

		ed3.setEnabled(false);
		ed3.setKeyListener(null);
		

		ed4.setEnabled(false);
		ed4.setKeyListener(null);
		
		sb1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){ 

			   @Override 
			   public void onProgressChanged(SeekBar seekBar, int progress, 
			     boolean fromUser) { 
			    // TODO Auto-generated method stub 
			    ed1.setText(String.valueOf(progress)); 
			   } 

			   @Override 
			   public void onStartTrackingTouch(SeekBar seekBar) { 
			    // TODO Auto-generated method stub 
			   } 

			   @Override 
			   public void onStopTrackingTouch(SeekBar seekBar) { 
			    // TODO Auto-generated method stub 
			   } 
			       }); 
			   
		
	

	
	sb2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){ 

		   @Override 
		   public void onProgressChanged(SeekBar seekBar, int progress, 
		     boolean fromUser) { 
		    // TODO Auto-generated method stub 
		    ed2.setText(String.valueOf(progress)); 
		   } 

		   @Override 
		   public void onStartTrackingTouch(SeekBar seekBar) { 
		    // TODO Auto-generated method stub 
		   } 

		   @Override 
		   public void onStopTrackingTouch(SeekBar seekBar) { 
		    // TODO Auto-generated method stub 
		   } 
		       }); 
		   
	

	
	sb3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){ 

		   @Override 
		   public void onProgressChanged(SeekBar seekBar, int progress, 
		     boolean fromUser) { 
		    // TODO Auto-generated method stub 
		    ed3.setText(String.valueOf(progress)); 
		   } 

		   @Override 
		   public void onStartTrackingTouch(SeekBar seekBar) { 
		    // TODO Auto-generated method stub 
		   } 

		   @Override 
		   public void onStopTrackingTouch(SeekBar seekBar) { 
		    // TODO Auto-generated method stub 
		   } 
		       }); 
		   
	
	
	new Thread(new Runnable() {
        @Override
        public void run() {
        	startTime = System.currentTimeMillis();
            while (true) {
                try {
                    Thread.sleep(20);
                    mHandler.post(new Runnable() {

                        @Override
                        public void run() {
                        	
                        	long currentTime = System.currentTimeMillis();
                        	
                        	int sb1v = sb1.getProgress();
                        	int sb2v = sb2.getProgress();
                        	int sb3v = sb3.getProgress();
                        	
                        	
                        	
                        	int x = (int) (currentTime - startTime)/100;  
                        	
                        	x -= 2 * sb1v + sb2v+ sb3v;
                        	
                        	sb4.setProgress(x);
                        }
                    });
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
        }
    }).start();
	
	

	sb4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){ 

	   @Override 
	   public void onProgressChanged(SeekBar seekBar, int progress, 
	     boolean fromUser) { 
	    // TODO Auto-generated method stub 
	    ed4.setText(String.valueOf(progress)); 
	   } 

	   @Override 
	   public void onStartTrackingTouch(SeekBar seekBar) { 
	    // TODO Auto-generated method stub 
	   } 

	   @Override 
	   public void onStopTrackingTouch(SeekBar seekBar) { 
	    // TODO Auto-generated method stub 
	   } 
	       }); 
	   

}
	
	
	

	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
