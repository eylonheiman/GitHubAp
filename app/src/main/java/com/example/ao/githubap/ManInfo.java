package com.example.ao.githubap;

public class ManInfo {


    private String userName;
    private String email;
    private int imamgeResurce;

    ManInfo(String userName_, String email_, int imamgeResurce_){
        userName = userName_;
        email = email_;
        imamgeResurce = imamgeResurce_;
    }

    public String GetuserName(){
        return userName;
    }

    public String GetEmail(){
        return email;
    }

    public int GetImageResurce(){
        return imamgeResurce;
    }


}
