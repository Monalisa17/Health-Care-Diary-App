package com.example.brittany.hcd;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
// Information: http://www.androidbegin.com/tutorial/android-parse-com-simple-listview-tutorial/
public class Workout_overview extends AppCompatActivity {

    // Declare Variables
    ListView listview;
    List<ParseObject> ob;
    ProgressDialog mProgressDialog;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_overview);
        new RemoteDataTask().execute();
    }

    // RemoteDataTask AsyncTask
    private class RemoteDataTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(Workout_overview.this);
            // Set progressdialog title
            mProgressDialog.setTitle("Routine Overview");
            // Set progressdialog message
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            // Show progressdialog
            mProgressDialog.show();
        }
        @Override
        protected Void doInBackground(Void... params) {
            // Locate the class table named "Add_Exercise" in Parse.com
            ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(
                    "Add_Exercise");
            query.orderByAscending("Name");

//            USE FOR LAST MONTH DATA - NOT TESTED
//
//            // Today - Midnight; 00:00 is the first minute of the next day
//            Calendar date = new GregorianCalendar();
//
//            // Get Last month - FirstDay
//            date.set(Calendar.MONTH,date.get(Calendar.MONTH)-1); // Last Month
//            date.set(Calendar.DAY_OF_MONTH,1); // first day
//            // reset hour, minutes, seconds and millis
//            date.set(Calendar.HOUR_OF_DAY, 0);
//            date.set(Calendar.MINUTE, 0);
//            date.set(Calendar.SECOND, 0);
//            date.set(Calendar.MILLISECOND, 0);
//            Date firstdayMonth = date.getTime();
//
//            // Get Last month - LastDay
//            date.set(Calendar.MONTH,date.get(Calendar.MONTH)-1); // Last Month
//            date.set(Calendar.DAY_OF_MONTH,31); // Last day
//            // reset hour, minutes, seconds and millis
//            date.set(Calendar.HOUR_OF_DAY, 23);
//            date.set(Calendar.MINUTE, 59);
//            date.set(Calendar.SECOND, 59);
//            date.set(Calendar.MILLISECOND, 59);
//            Date lastdayMonth = date.getTime();
//
//
//            try {
//                query.whereGreaterThan("createdAt", firstdayMonth);
//                query.whereLessThan("createdAt", lastdayMonth);
//                ob = query.find();
//            } catch (ParseException e) {
//                Log.e("Error", e.getMessage());
//                e.printStackTrace();
//            }


            // Today - Midnight; 00:00 is the first minute of the next day
            Calendar date = new GregorianCalendar();
            // reset hour, minutes, seconds and millis
            date.set(Calendar.HOUR_OF_DAY, 0);
            date.set(Calendar.MINUTE, 0);
            date.set(Calendar.SECOND, 0);
            date.set(Calendar.MILLISECOND, 0);
            Date midnight = date.getTime();

            // Today - Before Midnight; 23:59 is the last minute of the day
            date.set(Calendar.HOUR_OF_DAY, 23);
            date.set(Calendar.MINUTE, 59);
            date.set(Calendar.SECOND, 59);
            date.set(Calendar.MILLISECOND, 59);
            Date beforemidnight = date.getTime();

            try {
                query.whereGreaterThan("createdAt", midnight);
                query.whereLessThan("createdAt", beforemidnight);
                ob = query.find();
            } catch (ParseException e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // Locate the listview in listview_main.xml
            listview = (ListView) findViewById(R.id.listview);
            // Pass the results into an ArrayAdapter
            adapter = new ArrayAdapter<String>(Workout_overview.this,
                    R.layout.activity_workout_overview_item);

            // Retrieve object "Name" from Parse.com database
            try {
                for (ParseObject exerciseView : ob) {
                    adapter.add((String) exerciseView.get("Name"));
                }
            } catch (Exception e) {
                Toast.makeText(Workout_overview.this, "No data found for today, GET TO WORK!", Toast.LENGTH_SHORT).show();
            }
            // Binds the Adapter to the ListView
            listview.setAdapter(adapter);
            // Close the progressdialog
            mProgressDialog.dismiss();
            // Capture button clicks on ListView items
            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    // Send single item click data to SingleItemView Class
                    Intent i = new Intent(Workout_overview.this,
                            Workout_overview_Details.class);

                    // Pass data
                    Bundle extras = new Bundle();

                    extras.putString("Name", ob.get(position).getString("Name").toString());
                    // extras.putString("objectId", ob.get(position).getString("objectId").toString());
                    extras.putString("objectId", ob.get(position).getObjectId().toString());
                    extras.putInt("Repetition", ob.get(position).getInt("Reps"));
                    extras.putInt("Duration", ob.get(position).getInt("Duration"));

                    i.putExtras(extras);

                    // Open SingleItemView.java Activity
                    startActivity(i);
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_workout_overview, menu);
        return true;
    }
    public void Description_clicked(View view)
    {
        Intent intent7 = new Intent(this, Workout_overview_Details.class);
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
