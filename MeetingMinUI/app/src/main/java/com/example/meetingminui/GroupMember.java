package com.example.meetingminui;

/**
 * Created by Jas on 4/16/2017.
 * Currently used by the ArrayAdapter that populates the ListView of all Members in a Group/ members added to a new group
 */
public class GroupMember {

    private String name;
    private String email;
    private boolean isMember;

    // Used to Add a Group Member
    public GroupMember(String _name, String _email) {
        this(true, _name, _email);
    }

    private GroupMember(boolean _isMember, String _name, String _email){
        isMember = _isMember;
        name = _name;
        email = _email;
    }

    public String getName(){
        return name;
    }

    public String getEmail() {
        return email;
    }

    public boolean getIsMember() {
        return isMember;
    }

    // Used to create the last item (Add Member) vs. all the other items (Member)
    public static GroupMember makeEmptyMember(){
        return new GroupMember(false, null, null);
    }


}
