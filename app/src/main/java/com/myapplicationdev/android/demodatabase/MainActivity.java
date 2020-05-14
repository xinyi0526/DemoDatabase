package com.myapplicationdev.android.demodatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnInsert, btnGetTasks;
    TextView tvResults;

    ListView lv;
    ArrayAdapter aa;
    ArrayList<Task> Tasks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnInsert = findViewById(R.id.btnInsert);
        btnGetTasks = findViewById(R.id.btnGetTasks);
        tvResults = findViewById(R.id.tvResults);

        lv = (ListView)this.findViewById(R.id.lv);

        DBHelper db = new DBHelper(MainActivity.this);
        Tasks = db.getTasks();
        db.close();

        aa = new TaskAdapter(this,R.layout.row,Tasks);
        lv.setAdapter(aa);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                db.insertTask("Submit RJ", "14 May 2016");
                db.close();


            }
        });

        btnGetTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                ArrayList<String> data = db.getTaskContent();
                ArrayList<Task> newTasks  = db.getTasks();
                Tasks = (db.getTasks());
                db.close();

                String txt = "";
                for (int i = 0; i < data.size(); i++) {
                    Log.d("Database Content", i +". "+data.get(i));
                    txt += i + ". " + data.get(i) + "\n";
                }


                tvResults.setText(txt);
                Tasks.clear();
                for(int i = 0;i < newTasks.size();i++){
                    Tasks.add(newTasks.get(i));
                }
                aa.notifyDataSetChanged();

            }
        });
    }
}
