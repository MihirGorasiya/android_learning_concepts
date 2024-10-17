package com.boomslang.localnotificationwithworkmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.boomslang.localnotificationwithworkmanager.ui.theme.LocalNotificationWithWorkManagerTheme
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import java.util.concurrent.TimeUnit

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalPermissionsApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LocalNotificationWithWorkManagerTheme {
                val postNotificationPermission = rememberPermissionState(permission = android.Manifest.permission.POST_NOTIFICATIONS)
                val notificationHandler = NotificationHandler(this)

                LaunchedEffect(key1 = Unit){
                    if(!postNotificationPermission.status.isGranted){
                        postNotificationPermission.launchPermissionRequest()

                    }
                }

                fun scheduleBackgroundTask(){
                    val customWorkRequest = PeriodicWorkRequestBuilder<CustomWorker>(15, TimeUnit.MINUTES).build()

                    WorkManager.getInstance(this).enqueue(customWorkRequest)
                }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center,) {
                            ElevatedButton(onClick = { notificationHandler.showSimpleNotification() }) {
                                Text(text = "Request Notification")
                            }
                            ElevatedButton(onClick = { scheduleBackgroundTask() }) {
                                Text(text = "Set Background Task")
                            }
                        }
                    }
                }
            }
        }
    }
}
