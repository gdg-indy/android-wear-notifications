package com.gdgindy.wearnotifications;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MyActivity extends Activity {

    private Button showNotificationButton;
    private Button hideNotificationButton;

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        showNotificationButton = (Button)findViewById(R.id.show_notification_button);
        showNotificationButton.setOnClickListener(showNotificationClickListener);

        hideNotificationButton = (Button)findViewById(R.id.hide_notification_button);
        hideNotificationButton.setOnClickListener(hideNotificationClickListener);
    }

    private View.OnClickListener showNotificationClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Notifications.showNotification(context);
        }
    };

    private View.OnClickListener hideNotificationClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
//            Notifications.hideNotification(context);
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
