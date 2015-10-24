package com.example.brittany.hcd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class Pushup_save extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pushup_save);

        // Get the parameters passed
        Bundle extras = getIntent().getExtras();
        String pushdone_string = extras.getString("EXTRA_PUSHDONE");
        int pushgoal_integer = extras.getInt("EXTRA_PUSHGOAL", 0);

        // Display Value
        TextView displayGoal = (TextView) findViewById(R.id.textView_goalSave);
        displayGoal.setText(pushdone_string);

        if(Integer.parseInt(pushdone_string) > pushgoal_integer)
        {
            Toast t = Toast.makeText(this, "CONGRATULATIONS YOU BEAT YOUR GOAL!!!", Toast.LENGTH_SHORT);
            t.show();
        }
        if(Integer.parseInt(pushdone_string) == pushgoal_integer)
        {
            Toast t = Toast.makeText(this, "CONGRATULATIONS YOU REACHED YOUR GOAL!!!", Toast.LENGTH_SHORT);
            t.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pushup_save, menu);
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
}
