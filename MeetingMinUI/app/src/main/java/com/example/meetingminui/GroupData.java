package com.example.meetingminui;

/**
 * Created by Jas on 4/15/2017.
 * Currently used by the ArrayAdapter that populates the List View of all the Groups
 */
public class GroupData {

    private String name;
    private boolean isGroup;

    // Used to Add a Group
    public GroupData (String _name) {
        this(true, _name);
    }

    private GroupData (boolean _isGroup, String _name){
        isGroup = _isGroup;
        name = _name;
    }


    public String getName(){
        return name;
    }

    public boolean getIsGroup(){
        return isGroup;
    }


    // Used to create the last item (Add Group) vs. all the other items (Groups)
    public static GroupData makeEmptyGroup(){
        return new GroupData(false, null);
    }


}
