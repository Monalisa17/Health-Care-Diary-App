package com.example.brittany.hcd;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;

import com.parse.Parse;
import com.parse.ParseInstallation;

import java.util.Random;

public class UserMainPage extends AppCompatActivity {

    String username = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main_page);
    }
    @Override
    protected void onResume() {
        super.onResume();
        // Get the intent with the extra parameter
        Intent intent = getIntent();
        username = intent.getStringExtra("username");

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user_main_page, menu);
        return true;
    }

    public void Symptoms_clicked(View view)
    {
        Intent intent_Symptoms = new Intent(this, Symptoms_Main.class);
        startActivity(intent_Symptoms);
    }

    public void Workout_clicked(View view)
    {
        Intent intent_workout = new Intent(this, Workout_Main.class);
        intent_workout.putExtra("username", username);
        startActivity(intent_workout);
    }
    public void Food_diary_clicked(View view)
    {
        Intent intent_food = new Intent(this, Food_Diary_Takeimage.class);
        startActivity(intent_food);
    }
    public void Report_clicked(View view)
    {
        Intent intent_Report = new Intent(this, Report_main.class);
        startActivity(intent_Report);
    }
    public void Logout_clicked(View view)
    {
        Intent intent_logout = new Intent(this, MainActivity.class);
        startActivity(intent_logout);
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
}
