package com.gdgindy.wearnotifications;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.NotificationCompat.WearableExtender;

public class Notifications {

    private static final String NOTIFICATION_GROUP = "gdg-indy-notifications";

    private static int notificationId = 0;

    public static void showNotification(Context context) {
        notificationId++;

        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setContentTitle("Notification title")
                        .setContentText("Hey! A notification!")
                ;

        addPendingIntent(notificationBuilder, context);

        setGroup(notificationBuilder);

        notify(notificationBuilder, context);

        if(notificationId > 1) {
            showGroupSummaryNotification(context);
        }
    }

    private static void notify(NotificationCompat.Builder notificationBuilder, Context context) {
        // Get an instance of the NotificationManager service
        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(context);

        // Build the notification and issues it with notification manager.
        notificationManager.notify(notificationId, notificationBuilder.build());
    }

    private static void addPendingIntent(NotificationCompat.Builder notificationBuilder, Context context) {
        // Build intent for notification content
        Intent viewIntent = new Intent(context, MyActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, viewIntent, 0);

        notificationBuilder.setContentIntent(pendingIntent);
    }

    private static void setGroup(NotificationCompat.Builder notificationBuilder) {
        notificationBuilder.setGroup(NOTIFICATION_GROUP);
    }

    private static void showGroupSummaryNotification(Context context) {
        notificationId++;

        // Build intent for notification content
        Intent viewIntent = new Intent(context, MyActivity.class);
        PendingIntent viewPendingIntent =
                PendingIntent.getActivity(context, 0, viewIntent, 0);

        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(context)
                        .setContentTitle("A notification group")
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setStyle(new NotificationCompat.InboxStyle()
                                .addLine("Group line 1   Hey! A notification!")
                                .addLine("Group line 2   Hey! A notification!")
                                .setBigContentTitle("A notification group")
                                .setSummaryText("Here is a group of notifications"))
                        .setContentIntent(viewPendingIntent)
                        .setGroup(NOTIFICATION_GROUP)
                        .setGroupSummary(true)
                ;

        // Get an instance of the NotificationManager service
        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(context);

        // Build the notification and issues it with notification manager.
        notificationManager.notify(notificationId, notificationBuilder.build());
    }
}
