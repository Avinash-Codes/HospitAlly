package com.example.hospitally

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.example.hospitally.navigation.navigate
import com.example.hospitally.screen.StartDestination
import com.example.hospitally.ui.theme.HospitAllyTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val splashScreen = installSplashScreen()
        splashScreen.setKeepOnScreenCondition{true}

        //Adding Delay To Splash Screen
        CoroutineScope(Dispatchers.Main).launch {
            delay(260)
            splashScreen.setKeepOnScreenCondition{false}
        }
        setContent {
            HospitAllyTheme {
                val navController = rememberNavController()
                navigate(navController)
            }
        }
    }
}