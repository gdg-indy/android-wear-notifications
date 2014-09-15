package com.gdgindy.wearnotifications;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

public class GdgNotification {

    private static int notificationId = 0;

    protected Context context;

    public GdgNotification(Context context) {
        this.context = context;
    }

    public void show() {
        NotificationCompat.Builder notificationBuilder = build();
        notify(notificationBuilder);
    }

    protected NotificationCompat.Builder build() {
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setContentTitle("Notification title")
                        .setContentText("Hey! A notification!")
                ;

        addPendingIntent(notificationBuilder);

        return notificationBuilder;
    }

    protected void notify(NotificationCompat.Builder notificationBuilder) {
        // Get an instance of the NotificationManager service
        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(context);

        // Build the notification and issues it with notification manager.
        notificationManager.notify(getNewNotificationId(), notificationBuilder.build());
    }

    protected void addPendingIntent(NotificationCompat.Builder notificationBuilder) {
        // Build intent for notification content
        Intent viewIntent = new Intent(context, MyActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, viewIntent, 0);

        notificationBuilder.setContentIntent(pendingIntent);
    }

    protected int getNewNotificationId() {
        return ++notificationId;
    }
}
