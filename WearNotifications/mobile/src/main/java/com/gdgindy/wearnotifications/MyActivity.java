package com.gdgindy.wearnotifications;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MyActivity extends Activity {

    private Button plainNotificationButton;
    private Button groupedNotificationButton;
    private Button pagedNotificationButton;

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        plainNotificationButton = (Button)findViewById(R.id.plain_notification_button);
        plainNotificationButton.setOnClickListener(plainNotificationClickListener);

        groupedNotificationButton = (Button)findViewById(R.id.grouped_notification_button);
        groupedNotificationButton.setOnClickListener(groupedNotificationClickListener);

        pagedNotificationButton = (Button)findViewById(R.id.paged_notification_button);
        pagedNotificationButton.setOnClickListener(pagedNotificationClickListener);
    }

    private View.OnClickListener plainNotificationClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            new GdgNotification(context).show();
        }
    };

    private View.OnClickListener groupedNotificationClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            new GroupedNotification(context).show();
        }
    };

    private View.OnClickListener pagedNotificationClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            new PagedNotification(context).show();
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
