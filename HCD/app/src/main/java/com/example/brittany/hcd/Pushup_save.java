package com.example.brittany.hcd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

public class Pushup_save extends AppCompatActivity {

    TextView pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pushup_save);

        pass = (TextView) findViewById(R.id.textView_dbentry);



        // Get the parameters passed
        Bundle extras = getIntent().getExtras();
        String pushdone_string = extras.getString("EXTRA_PUSHDONE");
        int pushgoal_integer = extras.getInt("EXTRA_PUSHGOAL", 0);

        // Display Value
        TextView displayGoal = (TextView) findViewById(R.id.textView_goalSave);
        displayGoal.setText(pushdone_string);

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "9lsXvAhxazTezFl8oTEhCnGr3p9S0qNetMNgmmgR", "ZYWsX8HmLCoEBFkfwZuPljn2VNiaqDomcMbkFIrk");

        ParseObject PushupCount = new ParseObject("PushupCount");
        PushupCount.put("Count", pushdone_string);
        PushupCount.saveInBackground();

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


        if(Integer.parseInt(pushdone_string) > pushgoal_integer) {
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
        if (id == R.id.action_settings)
        {
            return true;
        }
        // return super.onOptionsItemSelected(item);
        if (id == R.id.action_bar)
        {

        }
        onBackPressed();
        return true;
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(Pushup_save.this, Workout_Main.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

        // startActivity(new Intent(this, Workout_Main.class));
        // finish();

    }
}
