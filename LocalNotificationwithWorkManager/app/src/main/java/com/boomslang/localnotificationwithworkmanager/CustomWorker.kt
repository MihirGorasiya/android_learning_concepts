package com.boomslang.localnotificationwithworkmanager

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class CustomWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    private val notificationHandler = NotificationHandler(context)
    override fun doWork(): Result {
        Thread.sleep(2000)

        notificationHandler.showSimpleNotification()
        return Result.success()
    }
}