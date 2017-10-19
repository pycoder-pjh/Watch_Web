package com.jpalle.watch_web;

/**
 * Created by jpalle
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;

import com.jpalle.watch_web.listeners.OnPermissionRequestListener;
import com.jpalle.watch_web.utils.PermissionManager;

public class Splash_screen_Activity extends Activity implements OnPermissionRequestListener{

    private static final int DELAY_SPLASH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
    }

    @Override
    protected void onResume(){
        super.onResume();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            PermissionManager mPermissionManager = new PermissionManager(Splash_screen_Activity.this, Splash_screen_Activity.this);
            gotoMainActivity();
        }
    }

    private void gotoMainActivity(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mInt_Map = new Intent(Splash_screen_Activity.this, MainActivity.class);
                startActivity(mInt_Map);
                finish();
            }
        }, DELAY_SPLASH);
    }

    @Override
    public void onPermissionRequest(String paramPermission, boolean isPermissionDeniedBefore, int paramRequestCode) {
        if (isPermissionDeniedBefore) {
            ActivityCompat.requestPermissions(Splash_screen_Activity.this, new String[]{paramPermission}, paramRequestCode);
        } else {
            ActivityCompat.requestPermissions(Splash_screen_Activity.this, new String[]{paramPermission}, paramRequestCode);
        }
    }
}
