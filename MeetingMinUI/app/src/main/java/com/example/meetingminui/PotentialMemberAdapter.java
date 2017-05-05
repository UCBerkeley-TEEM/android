package com.example.meetingminui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jas on 4/16/2017.
 * Used to Populate the List of Potential Members on NewGroupActivity
 */
public class PotentialMemberAdapter extends ArrayAdapter<GroupMember> {

    private ArrayList<GroupMember> potentialMembers;
    Context mContext;

    //View lookup cache
    private static class ViewHolder {
        TextView memName;       //item_title
        TextView memEmail;      //item_subtitle
        ImageView addPic;       //left_pic - Only for Add Member Item
        ImageView deletePic;    //right_pic
    }

    public PotentialMemberAdapter(ArrayList<GroupMember> _members, Context _context){
        super(_context, R.layout.row_item_layout, _members);
        this.potentialMembers = _members;
        this.mContext = _context;

        if (potentialMembers.get(potentialMembers.size()-1).getIsMember()){
            potentialMembers.add(GroupMember.makeEmptyMember()); //puts the "Add Member" item to end of list if not already
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        //Get data for this position
        GroupMember member = getItem(position);

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
            viewHolder.memName = (TextView) convertView.findViewById(R.id.item_title);
            viewHolder.deletePic = (ImageView) convertView.findViewById(R.id.right_pic);
            viewHolder.addPic = (ImageView) convertView.findViewById(R.id.left_pic);
            viewHolder.memEmail = (TextView) convertView.findViewById(R.id.item_subtitle);

            res = convertView;
            convertView.setTag(viewHolder);
        }

        if (member.getIsMember()){
            viewHolder.addPic.setVisibility(View.INVISIBLE);
            viewHolder.deletePic.setVisibility(View.VISIBLE);
            viewHolder.memEmail.setVisibility(View.VISIBLE);

            viewHolder.memName.setText(member.getName());
            viewHolder.memEmail.setText(member.getEmail());
            viewHolder.deletePic.setImageResource(R.drawable.minus);
        } else {
            viewHolder.addPic.setVisibility(View.VISIBLE);
            viewHolder.deletePic.setVisibility(View.INVISIBLE);
            viewHolder.memEmail.setVisibility(View.INVISIBLE);

            viewHolder.memName.setText("Add Member");
            viewHolder.addPic.setImageResource(R.drawable.plus);
        }


        return res;
    }


}
