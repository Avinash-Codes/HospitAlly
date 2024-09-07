package com.example.hospitally.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.hospitally.screen.OptionsToChoose
import com.example.hospitally.screen.RegisterYourHospital
import com.example.hospitally.screen.StartDestination
import com.example.hospitally.screen.mains

@Composable
fun navigate(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "startScreen"){

        composable("startScreen"){
            StartDestination(navController)
        }
        composable("whatareappdo"){
            mains(navController)
        }

        composable("registeryourhospital"){
            RegisterYourHospital(navController)
        }

        composable("optionstochoose"){
            OptionsToChoose(navController)
        }
    }
}