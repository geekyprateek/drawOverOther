package com.prateektask2.Activities;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.prateektask2.R;
import com.prateektask2.Services.ChatHeadService;
import com.prateektask2.Services.GrabOnService;
import com.prateektask2.Utils;

public class MainActivity extends AppCompatActivity {

    public static int OVERLAY_PERMISSION_REQ_CODE_CHATHEAD = 1234;
    public static int OVERLAY_PERMISSION_REQ_CODE_CHATHEAD_MSG = 5678;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startService(new Intent(MainActivity.this, GrabOnService.class));

            if(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.BIND_ACCESSIBILITY_SERVICE) == PackageManager.PERMISSION_GRANTED){


        }else{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (shouldShowRequestPermissionRationale(Manifest.permission.BIND_ACCESSIBILITY_SERVICE)) {
                    Toast.makeText(getBaseContext(),"you need to give binding permission",Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(android.provider.Settings.ACTION_ACCESSIBILITY_SETTINGS);
                    startActivityForResult(intent, 0);
                }
            }

        }

        if(Utils.canDrawOverlays(MainActivity.this))
            startChatHead();
        else{
            requestPermission(OVERLAY_PERMISSION_REQ_CODE_CHATHEAD);
        }
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == OVERLAY_PERMISSION_REQ_CODE_CHATHEAD) {
            if (!Utils.canDrawOverlays(MainActivity.this)) {
                needPermissionDialog(requestCode);
            }else{
                startChatHead();
            }

        }else if(requestCode == OVERLAY_PERMISSION_REQ_CODE_CHATHEAD_MSG){
            if (!Utils.canDrawOverlays(MainActivity.this)) {
                needPermissionDialog(requestCode);
            }else{
                showChatHeadMsg();
            }

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(Utils.canDrawOverlays(MainActivity.this)) {
            startChatHead();
        }
    }

    private void startChatHead(){
        //startService(new Intent(MainActivity.this, ChatHeadService.class));
        //startService(new Intent(MainActivity.this,GrabOnService.class));
    }
    private void showChatHeadMsg(){
        java.util.Date now = new java.util.Date();
        String str = "test by henry  " + new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now);

        Intent it = new Intent(MainActivity.this, ChatHeadService.class);
        it.putExtra(Utils.EXTRA_MSG, str);
        startService(it);
    }



    private void needPermissionDialog(final int requestCode){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("You need to allow permission");
        builder.setPositiveButton("OK",
                new android.content.DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        requestPermission(requestCode);
                    }
                });
        builder.setNegativeButton("Cancel", new android.content.DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub

            }
        });
        builder.setCancelable(false);
        builder.show();
    }



    private void requestPermission(int requestCode){
        Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
        intent.setData(Uri.parse("package:" + getPackageName()));
        startActivityForResult(intent, requestCode);
    }
}
