package com.example.brittany.hcd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
public class User_add_exercise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_add_exercise);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user_add_exercise, menu);
        return true;
    }
    public void Add_exercise_clicked(View view)
    {
       Intent intent5 = new Intent(this, add_exercise.class);
        startActivity(intent5);
    }
    public void Pushup_clicked(View view)
    {
        Intent intent6 = new Intent(this, Pushup_goal.class);
        startActivity(intent6);
    }
    public void Heartrate_clicked(View view)
    {
        Intent intent7 = new Intent(this, Heart_rate_monitor_firstscreen.class);
        startActivity(intent7);
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
