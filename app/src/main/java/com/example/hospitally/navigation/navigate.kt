package com.example.hospitally.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.hospitally.screen.OptionsToChoose
import com.example.hospitally.screen.RegisterYourHospital
import com.example.hospitally.screen.SignInHospital
import com.example.hospitally.screen.SignInStaff
import com.example.hospitally.screen.StartDestination
import com.example.hospitally.screen.mains
import com.example.hospitally.viewmodel.HospitalInfo

@Composable
fun navigate(navController: NavHostController,viewModel: HospitalInfo) {
    NavHost(navController = navController, startDestination = "startScreen"){

        composable("startScreen"){
            StartDestination(navController)
        }
        composable("whatareappdo"){
            mains(navController)
        }

        composable("registeryourhospital"){
            RegisterYourHospital(navController,viewModel)
        }

        composable("optionstochoose"){
            OptionsToChoose(navController,viewModel)
        }

        composable("signinhospital"){
            SignInHospital(navController,viewModel)
        }

        composable("signinstaff"){
            SignInStaff(navController,viewModel)
        }
    }
}