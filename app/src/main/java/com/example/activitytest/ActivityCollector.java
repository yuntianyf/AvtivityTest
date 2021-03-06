package com.example.activitytest;

import android.app.Activity;
import java.util.List;

import java.util.ArrayList;

/**
 * Created by 86188 on 2018/7/19.
 */

public class ActivityCollector {
    public static List<Activity> activities = new ArrayList<>();
    public static void addActivity(Activity activity){
        activities.add(activity);
    }
    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }
    public static void finishAll(){
        for (Activity activity:activities){
            if (!activity.isFinishing()){
                activity.finish();
            }
            activities.clear();
        }
    }
}
