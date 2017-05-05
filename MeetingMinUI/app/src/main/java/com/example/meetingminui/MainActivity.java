package com.example.meetingminui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ListView listView;
    private android.support.v7.widget.Toolbar toolbar;

    private ArrayList<GroupData> grouplst;
    private static GroupDataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar_group_list);
        setSupportActionBar(toolbar);
        listView = (ListView) findViewById(R.id.group_list);
        grouplst = new ArrayList<>();

        grouplst.add(new GroupData("Final Project"));
        grouplst.add(new GroupData("MIMS"));
        grouplst.add(new GroupData("Book Club"));
        grouplst.add(new GroupData("Other Final Project"));
        grouplst.add(new GroupData("Dummy item"));
        grouplst.add(new GroupData("Dummy item 2"));
        grouplst.add(new GroupData("Dummy item 3"));
        grouplst.add(new GroupData("Dummy item 4"));
        grouplst.add(new GroupData("Dummy item 5"));
        grouplst.add(new GroupData("Dummy item 6"));

        adapter = new GroupDataAdapter(grouplst, getApplicationContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GroupData group = grouplst.get(position);
                if (position == grouplst.size() - 1) {
                    Log.d("MainAct-lstVw ItemClick", "Add Group");
                    // Go to NewGroup Activity - which gets a name and members for a new group
                    Intent next = new Intent(getBaseContext(), NewGroupActivity.class); //temporary
                    startActivity(next);
                } else {
                    Log.d("MainAct-lstVw ItemClick", group.getName());
                    // Go to GroupMeetingScheduler Activity - which has info about this Group's meetings and etc

                }
            }
        });
    }

}
