package com.prateektask2.Services;

import android.accessibilityservice.AccessibilityService;
import android.content.Intent;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;

/**
 * Created by prateekgupta on 10/10/16.
 */

public class GrabOnService extends AccessibilityService {


    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        Log.d("Accessibility","Started");
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        Log.d("prateek",accessibilityEvent.toString());
       // startActivity(new Intent(this, OverLayActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));

        String appname ="";
        Intent intent = new Intent(GrabOnService.this, ChatHeadService.class);
        String packageName = accessibilityEvent.getPackageName().toString();
        if(packageName.contains("flipkart")){
            appname = "flipkart";
        }else if(packageName.contains("jabong")) {
            appname = "jabong";
        }else if(packageName.contains("myntra")) {
            appname = "myntra";
        }else if(packageName.contains("amazon")) {
            appname = "amazon";
        }else if(packageName.contains("one97")) {
            appname = "one97";
        }

        intent.putExtra("appname",appname);
        startService(intent);
        Log.d("Accessibility","Intent Send");
    }

    @Override
    public void onInterrupt() {

    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("prateek",intent.toString());
        return super.onUnbind(intent);
    }
}
