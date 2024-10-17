package com.boomslang.localnotificationwithworkmanager

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import kotlin.random.Random

class NotificationHandler(private val context: Context) {
    private val notificationManager = context.getSystemService(NotificationManager::class.java)
    private val notificationChannelID = "notification_channel_id"

    fun showSimpleNotification(){
        val notification = NotificationCompat.Builder(context, notificationChannelID).setContentTitle("Test Notification").setContentText("This is a test notification.").setSmallIcon(
            R.drawable.ic_launcher_foreground).setPriority(NotificationCompat.PRIORITY_MAX).setAutoCancel(true).build()

        notificationManager.notify(Random.nextInt(), notification)
    }
}