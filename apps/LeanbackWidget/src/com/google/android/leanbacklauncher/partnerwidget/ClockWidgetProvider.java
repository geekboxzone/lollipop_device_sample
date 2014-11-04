
package com.google.android.leanbacklauncher.partnerwidget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.widget.RemoteViews;

public class ClockWidgetProvider extends AppWidgetProvider {


    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {

        ComponentName thisWidget = new ComponentName(context, ClockWidgetProvider.class);
        int[] allWidgetIds = appWidgetManager.getAppWidgetIds(thisWidget);
        for (int widgetId : allWidgetIds) {
            RemoteViews remoteView = new RemoteViews(context.getPackageName(),
                    R.layout.clock_widget);
            appWidgetManager.updateAppWidget(widgetId, remoteView);
        }

        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }
}
