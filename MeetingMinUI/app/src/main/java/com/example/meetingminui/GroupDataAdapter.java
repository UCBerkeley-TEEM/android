package com.example.meetingminui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jas on 4/15/2017.
 * Used to Populate the List of Groups on MainActivity
 */
public class GroupDataAdapter extends ArrayAdapter<GroupData> implements View.OnClickListener{

    private ArrayList<GroupData> groups;
    Context mContext;

    //View lookup cache
    private static class ViewHolder {
        ImageView groupPic; //left_pic
        TextView groupName; //item_title
        TextView subtitle;
        ImageView info;     //right_pic
    }

    public GroupDataAdapter(ArrayList<GroupData> _groups, Context _context){
        super(_context, R.layout.row_item_layout, _groups);
        this.groups = _groups;
        this.mContext = _context;

        if (groups.get(groups.size()-1).getIsGroup()){
            groups.add(GroupData.makeEmptyGroup()); //puts the "Add Group" item to end of grouplist if not already
        }

    }

    @Override
    public void onClick(View v){
        int index = (Integer) v.getTag();
        GroupData group = getItem(index);

        switch (v.getId()) {
            case (R.id.right_pic):
                // Go to GroupInfo Activity - which has list of Group Members and etc
                Log.d("Group ListView", "Clicked Group " + index + " info button");
                break;
            case (R.id.left_pic):

//                Log.d("Group ListView", "Clicked Group " + index + " group button");
                break;
        }
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        //Get data for this position
        GroupData group = getItem(position);

        ViewHolder viewHolder; //view lookup cache stored in tag

        final View res;
        //Check if an existing view is being reused, otherwise inflate the view
        if (convertView != null) {
            viewHolder = (ViewHolder) convertView.getTag();
            res = convertView;
        } else {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item_layout, parent, false);
            viewHolder.groupName = (TextView) convertView.findViewById(R.id.item_title);
            viewHolder.info = (ImageView) convertView.findViewById(R.id.right_pic);
            viewHolder.groupPic = (ImageView) convertView.findViewById(R.id.left_pic);
            viewHolder.subtitle = (TextView) convertView.findViewById(R.id.item_subtitle);

            res = convertView;
            convertView.setTag(viewHolder);
        }

        //Skip animation for now
//        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? ... );

        viewHolder.subtitle.setVisibility(View.INVISIBLE);
        if (group.getIsGroup()) {
            viewHolder.groupName.setText(group.getName());
            viewHolder.groupPic.setImageResource(R.drawable.placeholder); // Fix this once you have a strategy for getting group images
            viewHolder.info.setOnClickListener(this);
            viewHolder.info.setTag(position);
            viewHolder.info.setVisibility(View.VISIBLE);
//            viewHolder.info.setImageDrawable(R.drawable.ic_dialog_info); //Put info_sign img in resources
//            viewHolder.groupPic.setOnClickListener(this);
//            viewHolder.groupPic.setTag(position);
        } else {
            viewHolder.groupName.setText("Add Group");
            viewHolder.groupPic.setImageResource(R.drawable.plus);
            viewHolder.info.setOnClickListener(null);
            viewHolder.info.setTag(position);
            viewHolder.info.setVisibility(View.INVISIBLE);
//            viewHolder.groupPic.setOnClickListener(null);
//            viewHolder.groupPic.setTag(position);
        }

        return res; // if this dont work return convertView
    }

}
