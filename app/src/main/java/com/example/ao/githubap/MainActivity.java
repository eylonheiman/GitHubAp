package com.example.ao.githubap;

import android.app.AlertDialog;
import android.arch.core.executor.DefaultTaskExecutor;
import android.content.DialogInterface;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;





import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity {

    static Integer numOfUsersToShow = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Log.i("HI", "GIT HUB APP START!");

        setContentView(R.layout.activity_main);


//        String [] TheList = {"AAAA", "BBBB", "CCCC", "DDDD"};
        ManInfo man1 = new ManInfo("AAA", "aaa@aaa", 1);
        ManInfo man2 = new ManInfo("BBB", "bbb@bbb", 1);
        ManInfo man3 = new ManInfo("CCC", "ccc@ccc", 1);
        ManInfo[] TheList = {man1, man2, man3};

        ListAdapter theAdapter = new MyAdapter(this,TheList);
        ListView theListView = (ListView) findViewById(R.id.theListView);
        theListView.setAdapter(theAdapter);

        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String tvShowPicked = "You selected " +
                        String.valueOf(adapterView.getItemAtPosition(i));

                Toast.makeText(MainActivity.this, tvShowPicked, Toast.LENGTH_SHORT).show();

            }
        });


        View list = findViewById(R.id.fragment_man_projects);
        list.setVisibility(View.GONE);


    }


    public void Onclickbtn(View view){
        Log.i("HI", "CLICED!");

        View list = findViewById(R.id.fragment_list);
        list.setVisibility(View.GONE);
        View proj = findViewById(R.id.fragment_man_projects);
        proj.setVisibility(VISIBLE);
    }

///////////////////////////////////////////////////////////////



///////////////////////////////////////////////////////////////

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.set_list_length) {
            showChangeListLengthDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void showChangeListLengthDialog() {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog, null);
        dialogBuilder.setView(dialogView);

        final EditText edt = (EditText) dialogView.findViewById(R.id.editText);

        dialogBuilder.setTitle("Set list length");
//        dialogBuilder.setMessage("Enter text below");
        dialogBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

                String result = edt.getText().toString();
                if(result.isEmpty())
                    return;

                numOfUsersToShow = Integer.parseInt(result);

                TextView kot = findViewById(R.id.list_length_text);
                String newStr = "number of peopele to show ";
                newStr += numOfUsersToShow.toString();
                kot.setText(newStr);
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }




}



