package com.gdgindy.wearnotifications;

import android.app.Notification;
import android.content.Context;
import android.support.v4.app.NotificationCompat;

public class PagedNotification extends GdgNotification {

    public PagedNotification(Context context) {
        super(context);
    }

    @Override
    protected Notification getNotification(NotificationCompat.Builder notificationBuilder) {
        // Create a big text style for the second page
        NotificationCompat.BigTextStyle secondPageStyle = new NotificationCompat.BigTextStyle();
        secondPageStyle.setBigContentTitle("Page 2")
                .bigText("A lot of text...");

        // Create second page notification
        Notification secondPageNotification =
                new NotificationCompat.Builder(getContext())
                        .setStyle(secondPageStyle)
                        .build();

        // Add second page with wearable extender and extend the main notification
        Notification twoPageNotification =
                new NotificationCompat.WearableExtender()
                        .addPage(secondPageNotification)
                        .extend(notificationBuilder)
                        .build();

        return twoPageNotification;
    }
}
