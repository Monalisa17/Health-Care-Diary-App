package com.example.brittany.hcd;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class Pushup_count extends AppCompatActivity implements SensorEventListener {

    // Motivation Sayings
    private String[] pushit = {"Keep Going!","You don't get the ass you want by sitting on it", "Making excuses burns zero calories", "Sore the most satisfying pain",
            "Wake up, work out kick ass!",
            "Sweat is just fat crying",
            "Sweat, smile, and repeat",
            "You were born to lift",
            "You are almost there",
            "Don't Give up!",
            "Half Way!",
            "COME ON!",
            "PUSH IT!",
            "DO IT!",
            "RAWWWRRR!"};
    // Views
    private TextView proximityView;
    private TextView courageView;

    // Sensors
    private SensorManager sensorManager;
    // Variables
    int counter = 0;
    int motivation = 0;
    int divideNumber = 0;
    int goal = 0;
    String proximityOut = "0";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pushup_count);

        // Get the intent with the extra parameter
        Intent intent = getIntent();
        goal = intent.getIntExtra("parameter_name", 0);

        // Display Value
        TextView displayGoal = (TextView) findViewById(R.id.editText_reach);
        displayGoal.setText("" + goal); // set as string easier way to do it

        // Display Text view
        proximityView = (TextView) findViewById(R.id.textView_proximityView);
        courageView = (TextView) findViewById(R.id.textView_encourage); // change this view
        motivation = goal; // set as motivation

        // Real sensor Manager
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY),
                SensorManager.SENSOR_DELAY_GAME);
    }
    @Override
    protected void onResume() {
        super.onResume();
        // Register sensors listeners
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY),
                SensorManager.SENSOR_DELAY_GAME);

        divideNumber = motivation/15;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pushup_count, menu);
        return true;
    }
    public void done_clicked(View view)
    {
        Intent intent5 = new Intent(this, Pushup_save.class);
        Bundle extras = new Bundle();

        extras.putString("EXTRA_PUSHDONE",proximityOut);
        extras.putInt("EXTRA_PUSHGOAL", goal);

        intent5.putExtras(extras);
        startActivity(intent5);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // int i,j = 0;

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        synchronized (this)
        {


            switch (sensorEvent.sensor.getType()) {
                case Sensor.TYPE_PROXIMITY:

                    // j--;

                    proximityOut = Integer.toString((counter++)/2);
                    // if( (divideNumber == Integer.parseInt(proximityOut) )){courageView.setText(pushit[10]);}
//                    if( (j % divideNumber) == 0)
//                    {
//                        courageView.setText(pushit[i]);
//                        i++;
//                    }
                    proximityView.setText(proximityOut);
                    break;

            }
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
