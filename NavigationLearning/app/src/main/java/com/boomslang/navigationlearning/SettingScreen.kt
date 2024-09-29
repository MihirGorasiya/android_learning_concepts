package com.boomslang.navigationlearning

import androidx.compose.foundation.layout.Box
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
import com.boomslang.navigationlearning.ui.theme.Constants

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingScreen(navController: NavController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopAppBar(title = { Text(text = "Navigation Learning") }) },
    ) { innerPadding ->

        Box(modifier = Modifier.padding(innerPadding)) {
            Column {
                Text(
                    text = "Hello Android!"
                )
                Text(
                    text = "This is the settings page"
                )
                Button(onClick = { navController.navigate(Constants.HOME_ROUTE) }) {
                    Text(text = "Home")
                }
                Button(onClick = { navController.navigate(Constants.CHAT_ROUTE) }) {
                    Text(text = "Chat")
                }
                Button(onClick = { navController.popBackStack() }) {
                    Text(text = "Back")
                }
            }
        }

    }
}