package com.nicolas.notification

import android.app.*
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonSendNotification.setOnClickListener {

            /* When click notification, open new activity. */
            val intent = Intent(this, LauncherActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }

            /* Use sound default notify smartphone. */
            val uri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

            val pendingIntent: PendingIntent =
                PendingIntent.getActivities(this, 0, arrayOf(intent), 0)

            /* Config Notification. */
            val builder = NotificationCompat.Builder(this, "CHANNEL_ID")
                .setSmallIcon(R.drawable.ic_bxs_message_rounded_error)
                .setSound(uri)
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .setContentTitle("Lorem Ipsum")
                .setContentText("Is simply dummy text of the printing and typesetting industry.")
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)

                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            /* Show notification. */
            notificationManager.notify(0, builder.build())

        }
    }
}