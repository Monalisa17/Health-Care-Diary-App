package com.example.brittany.hcd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

public class add_exercise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exercise);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_exercise, menu);
        return true;
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


    public void Exercise_entered(View view) {



        ParseObject Add_Exercise = new ParseObject("Add_Exercise");
        Add_Exercise.put("Name", "ADD StRING NAME");

Add_Exercise.saveAllInBackground();
        Add_Exercise.saveAllInBackground()
        Add_Exercise.saveInBackground();

        // Check if it saved, will display on the app
        PushupCount.saveInBackground(new SaveCallback()
        {
            @Override
            public void done(ParseException e) {
                if (e != null) {
                    // Log.e("PARSE.COM", "FAILED" + e.getMessage());
                    pass.setText("Did not save! ");
                } else {
                    // Log.e("PARSE.COM", "SUCCESS");
                    pass.setText("Has been saved! ");

                }
            }
        });


    }


}
