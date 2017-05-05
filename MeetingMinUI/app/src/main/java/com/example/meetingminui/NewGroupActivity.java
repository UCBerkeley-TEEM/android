package com.example.meetingminui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NewGroupActivity extends AppCompatActivity {

    private EditText groupName;
    private ListView listView;
    private ArrayList<GroupMember> memberlst;
    private static PotentialMemberAdapter adapter;
    private android.support.v7.widget.Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_group);

        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar_new_group);
        setSupportActionBar(toolbar);
        listView = (ListView) findViewById(R.id.new_member_list);
        memberlst = new ArrayList<>();

        memberlst.add(new GroupMember("Mike Snow", "msnow@gmail.com"));
        memberlst.add(new GroupMember("Jack Black", "jb@gmail.com"));
        memberlst.add(new GroupMember("Jenny Smith", "js222@gmail.com"));

        adapter = new PotentialMemberAdapter(memberlst, getApplicationContext());

        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                if (position == memberlst.size() - 1) {
//                    Log.d("NewGroupAct", "Clicked Add Member");
//                }
//            }
//        });

    }
}
