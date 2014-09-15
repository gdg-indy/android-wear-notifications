package com.gdgindy.wearnotifications;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

public class GdgNotification {

    private static int notificationId = 0;

    private Context context;

    public GdgNotification(Context context) {
        this.context = context;
    }

    public void show() {
        NotificationCompat.Builder notificationBuilder = build();
        notify(getNotification(notificationBuilder));
    }

    protected NotificationCompat.Builder build() {
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(getContext())
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setContentTitle("Notification title")
                        .setContentText("Hey! A notification!")
                ;

        addPendingIntent(notificationBuilder);

        return notificationBuilder;
    }

    protected Notification getNotification(NotificationCompat.Builder notificationBuilder) {
        return notificationBuilder.build();
    }

    protected void notify(Notification notification) {
        // Get an instance of the NotificationManager service
        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(getContext());

        // Build the notification and issues it with notification manager.
        notificationManager.notify(getNewNotificationId(), notification);
    }

    protected void addPendingIntent(NotificationCompat.Builder notificationBuilder) {
        // Build intent for notification content
        Intent viewIntent = new Intent(getContext(), MyActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(getContext(), 0, viewIntent, 0);

        notificationBuilder.setContentIntent(pendingIntent);
    }

    protected int getNewNotificationId() {
        return ++notificationId;
    }

    protected Context getContext() {
        return context;
    }
}
