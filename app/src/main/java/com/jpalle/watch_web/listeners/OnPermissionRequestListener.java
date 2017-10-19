package com.jpalle.watch_web.listeners;

/**
 * Created by jpalle
 */

public interface OnPermissionRequestListener {
    public void onPermissionRequest(String paramPermission, boolean isPermissionDeniedBefore, int paramRequestCode);
}
