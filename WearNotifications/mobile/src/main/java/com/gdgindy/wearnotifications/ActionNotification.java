package com.gdgindy.wearnotifications;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

public class ActionNotification extends GdgNotification {

    public ActionNotification(Context context) {
        super(context);
    }

    @Override
    protected NotificationCompat.Builder build() {
        // Build an intent for an action to view a map
        Intent mapIntent = new Intent(Intent.ACTION_VIEW);

        Uri geoUri = Uri.parse("geo:0,0");
        mapIntent.setData(geoUri);
        PendingIntent mapPendingIntent = PendingIntent.getActivity(getContext(), 0, mapIntent, 0);

        NotificationCompat.Builder notificationBuilder = super.build();

        notificationBuilder
                .addAction(android.R.drawable.ic_dialog_map,
                        getContext().getString(R.string.map), mapPendingIntent);

        return notificationBuilder;
    }
}
