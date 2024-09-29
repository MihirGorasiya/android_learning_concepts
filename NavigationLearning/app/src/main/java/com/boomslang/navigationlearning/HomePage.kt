package com.boomslang.navigationlearning

import android.provider.ContactsContract
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun HomePage(profile: String, navController: NavController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopAppBar(title = { Text(text = "Navigation Learning") }) },
    ) { innerPadding ->

        Column {
            Text(
                text = "Hello Android! $profile",
                modifier = Modifier.padding(innerPadding)
            )
            Text(
                text = "This is the home page",
                modifier = Modifier.padding(innerPadding)
            )
            Button(onClick = { navController.navigate("settings") }) {
                Text(text = "Settings")
            }
        }
    }
}