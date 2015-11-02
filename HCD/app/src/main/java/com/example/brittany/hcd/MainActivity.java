package com.example.brittany.hcd;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;

import com.parse.Parse;
import com.parse.ParseInstallation;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onResume() {
        super.onResume();
        initParse(); // another way without using class
    }
    private void initParse() {
        try
        {
            // Enable Local Datastore.
            Parse.enableLocalDatastore(this);
            Parse.initialize(this, "9lsXvAhxazTezFl8oTEhCnGr3p9S0qNetMNgmmgR", "ZYWsX8HmLCoEBFkfwZuPljn2VNiaqDomcMbkFIrk");
            ParseInstallation.getCurrentInstallation().saveInBackground();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void Login_clicked(View view)
    {
        Intent intent_login = new Intent(this, UserMainPage.class);
        startActivity(intent_login);
    }
    public void Create_account_click(View view)
    {
        Intent intent_caccount = new Intent(this, Create_user.class);
        startActivity(intent_caccount);
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
