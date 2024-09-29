package com.boomslang.navigationlearning

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.boomslang.navigationlearning.ui.theme.Constants

@Composable
fun ChatPage(navController: NavController) {
    Column {
        for (i in 1..10) {
            ChatTile()
        }
        Button(onClick = { navController.navigate(Constants.HOME_ROUTE) }) {
            Text(text = "Home")
        }
        Button(onClick = { navController.navigate(Constants.SETTINGS_ROUTE) }) {
            Text(text = "Setting")
        }
        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Back")
        }
    }
}

@Composable
fun ChatTile() {
    Row(horizontalArrangement = Arrangement.SpaceBetween) {
        Text(text = "UserName")
        Text(text = "00:45")
    }
}