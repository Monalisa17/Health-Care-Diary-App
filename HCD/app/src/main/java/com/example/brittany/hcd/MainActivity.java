package com.example.brittany.hcd;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
<<<<<<< HEAD
=======
import android.widget.Toast;
import android.app.ProgressDialog;
>>>>>>> refs/remotes/origin/master

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParseUser;
import com.parse.ParseException;
import com.parse.LogInCallback;

public class MainActivity extends ActionBarActivity {
    // MY_PREFS_NAME - a static String variable like:
    // public static final String MY_PREFS_NAME = "MyPrefsFile";

    private EditText usernameview;
    private EditText passwordview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

<<<<<<< HEAD


=======
        usernameview = (EditText) findViewById(R.id.username);
        passwordview = (EditText) findViewById(R.id.password);
>>>>>>> refs/remotes/origin/master
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
<<<<<<< HEAD
        EditText username = (EditText) findViewById(R.id.editText_user);


//        // SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
//        editor.putString("username", username.getText().toString().trim());
//        editor.putInt("idName", 12);
//        editor.commit();

        Intent intent_login = new Intent(this, UserMainPage.class);
        // intent_login.putExtra("username", username.getText().toString().trim());

        startActivity(intent_login);
=======
        boolean validationerror =false;
        StringBuilder validationerrormessage = new StringBuilder("Please ");

        if(isEmpty(usernameview)) {
            validationerror = true;
            validationerrormessage.append("enter a username");
        }
        if(isEmpty(passwordview)) {
            if(validationerror) {
                validationerrormessage.append(" and ");
            }
            validationerror = true;
            validationerrormessage.append("enter a password");
        }
        validationerrormessage.append(".");

        if(validationerror){
            Toast.makeText(MainActivity.this,validationerrormessage.toString(),Toast.LENGTH_LONG).show();
            return;
        }

        final ProgressDialog dig = new ProgressDialog(this);
        dig.setTitle("Please wait.");
        dig.setMessage("Signing up. Please wait.");
        dig.show();

        ParseUser user = new ParseUser();
        user.setUsername(usernameview.getText().toString());
        user.setPassword(passwordview.getText().toString());

        user.logInInBackground(usernameview.getText().toString(), passwordview.getText().toString(),
                new LogInCallback() {
                    @Override
                    public void done(ParseUser parseUser, ParseException e) {
                        dig.dismiss();
                        if (e != null) {
                            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        } else {
                            Intent intent_login = new Intent(MainActivity.this, UserMainPage.class);
                            intent_login.putExtra("usernameintent", usernameview.getText().toString());
                            intent_login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent_login);
                        }
                    }
                });
    }

    private boolean isEmpty(EditText ettext)
    {
        if(ettext.getText().toString().trim().length() > 0){
            return false;
        }else {
            return true;
        }
    }

    private boolean isMatching(EditText text1 , EditText text2)
    {
        if(text1.getText().toString().equals(text2.getText().toString())){
            return true;
        }else{
            return false;
        }
>>>>>>> refs/remotes/origin/master
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