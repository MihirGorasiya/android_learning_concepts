package com.boomslang.navigationlearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.boomslang.navigationlearning.ui.theme.Constants
import com.boomslang.navigationlearning.ui.theme.NavigationLearningTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationLearningTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = Constants.HOME_ROUTE) {
                    composable(Constants.HOME_ROUTE) {
                        HomePage(
                            profile = "Mihir Gorasiya", navController = navController,
                        )
                    }
                    composable(Constants.SETTINGS_ROUTE) {
                        SettingScreen(navController = navController)
                    }
                    composable(Constants.CHAT_ROUTE) {
                        ChatPage(navController = navController)
                    }
                }

            }
        }
    }
}