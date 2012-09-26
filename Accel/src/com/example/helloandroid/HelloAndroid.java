package com.example.helloandroid;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;

public class HelloAndroid extends Activity implements SensorEventListener {
	private SensorManager sensorManager;

	private MediaPlayer mpSplash;

	TextView xCoor; // declare X axis object
	TextView yCoor; // declare Y axis object
	TextView zCoor; // declare Z axis object

	@Override
	public void onCreate(Bundle savedInstanceState){

		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		//mpSplash = MediaPlayer.create(this, R.raw.sword_stab);
		
		xCoor=(TextView)findViewById(R.id.xcoor); // create X axis object
		yCoor=(TextView)findViewById(R.id.ycoor); // create Y axis object
		zCoor=(TextView)findViewById(R.id.zcoor); // create Z axis object

		sensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
		// add listener. The listener will be HelloAndroid (this) class
		sensorManager.registerListener(this,
				sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
				SensorManager.SENSOR_DELAY_NORMAL);

		/*	More sensor speeds (taken from api docs)
		    SENSOR_DELAY_FASTEST get sensor data as fast as possible
		    SENSOR_DELAY_GAME	rate suitable for games
		 	SENSOR_DELAY_NORMAL	rate (default) suitable for screen orientation changes
		*/
	}

	public void onAccuracyChanged(Sensor sensor,int accuracy){

	}

	public void onSensorChanged(SensorEvent event){

		// check sensor type
		if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER){

			// assign directions
			float x=event.values[0];
			float y=event.values[1];
			float z=event.values[2];
			
		/*	
			int counter = 0;
			
			if(Math.abs(y) < 1) {
				counter ++;	
			}
			else {
				if(Math.abs(y) > 6 && counter > 100)	
					mpSplash.start();	
					counter = 0;
			}
			
			System.out.println("x: "+ x + " y:" + y + " z: " + z );
*/
			xCoor.setText("X: "+x);
			yCoor.setText("Y: "+y);
			zCoor.setText("Z: "+z);
		}
	}
}