package com.jpalle.watch_web.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import com.jpalle.watch_web.listeners.OnPermissionRequestListener;

/**
 * Created by jpalle
 */

public class PermissionManager {
    private Context mContext;
    private OnPermissionRequestListener mOnPermissionRequestListener;

    public PermissionManager(Context paramContext, OnPermissionRequestListener paramOnPermissionRequestListener)
    {
        this.mContext = paramContext;
        this.mOnPermissionRequestListener = paramOnPermissionRequestListener;
    }
}