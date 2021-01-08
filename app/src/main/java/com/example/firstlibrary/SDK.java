package com.example.firstlibrary;

import android.app.Activity;
import android.content.Intent;

import com.example.firstlibrary.activity.UserActivity;
import com.example.firstlibrary.listener.UserInfolistener;
import com.example.firstlibrary.model.User;

public class SDK {
    private static final SDK launch = new SDK();
    Activity mActivity;
    UserInfolistener userInfolistener;

    private SDK(){
    }

    public static SDK getInstance(){
        return  launch;
    }


    public void init(Activity activity, UserInfolistener userInfolistener){
        mActivity= activity;
        this.userInfolistener = userInfolistener;
    }

    public void startLauncherActivity(){
        Intent intent = new Intent(this.mActivity, UserActivity.class);
        this.mActivity.startActivity(intent);
    }

    public void setUserData(User user){
        userInfolistener.onUserInfoReceived(user);
    }
}
