package com.johnkeenoy.notifications;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.view.View;



public class MainActivity extends ActionBarActivity {

    NotificationCompat.Builder notification;
    private static int uniqueID = 43221;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notification = new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);


    }

    public void johnsButtonClicked (View view){
        //build the notification
        notification.setSmallIcon(R.drawable.gs_icon_a);
        notification.setTicker("This is a notification");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("This is the title");
        notification.setContentText("This is the text of the notification");

        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        //builds notification and issues it

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(uniqueID,notification.build());
        

    }

}




















