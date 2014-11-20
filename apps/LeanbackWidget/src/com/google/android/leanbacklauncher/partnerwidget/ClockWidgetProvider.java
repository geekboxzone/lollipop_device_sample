
package com.google.android.leanbacklauncher.partnerwidget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;

public class ClockWidgetProvider extends AppWidgetProvider {

    @Override
    public void onReceive(Context context, Intent intent) {
        update(context);
        super.onReceive(context, intent);
    }

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        update(context);
        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }

    private void update(Context context) {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        ComponentName thisWidget = new ComponentName(context, ClockWidgetProvider.class);
        appWidgetManager.updateAppWidget(thisWidget, getRemoteViews(context));
    }

    private RemoteViews getRemoteViews(Context context) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(),
                R.layout.clock_widget);
        remoteViews.setImageViewResource(R.id.connectivity_indicator, getConnectedResId(context));

        return remoteViews;
    }

    private static int getConnectedResId(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();

        int resId = 0;
        if (info == null || !info.isAvailable()) {
            resId = R.drawable.ic_widget_wifi_not_connected;
        } else if (!info.isConnected()) {
            resId = R.drawable.ic_widget_wifi_no_internet;
        } else {
            // internet is connected and working, show nothing
            resId = android.R.color.transparent;
        }

        return resId;
    }
}
