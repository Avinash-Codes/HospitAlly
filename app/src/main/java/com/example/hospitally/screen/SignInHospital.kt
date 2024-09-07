package com.example.hospitally.screen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hospitally.viewmodel.HospitalInfo

@Composable
fun SignInHospital(navController: NavController, viewModel: HospitalInfo) {
    var showToast by rememberSaveable { mutableStateOf(false) }
    val context = LocalContext.current
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        item {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Registration Number",
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 25.sp
                )
                OutlinedTextField(
                    value = viewModel.hospitalName,
                    onValueChange = {
                        viewModel.hospitalName = it
                    },
                    modifier = Modifier
                        .border(
                            width = 3.dp,
                            color = Color(0xFFb12856),
                            shape = RoundedCornerShape(16.dp)
                        ),
                    shape = RoundedCornerShape(16.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color.Transparent,
                        focusedBorderColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                    ),
                )
            }

            Column(
                modifier = Modifier.fillMaxSize()
                    .padding(top = 18.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    "Password",
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 25.sp
                )
                OutlinedTextField(
                    value = viewModel.hospitalRegistrationNumber,
                    onValueChange = {
                        viewModel.hospitalRegistrationNumber = it
                    },
                    modifier = Modifier
                        .border(
                            width = 3.dp,
                            color = Color(0xFFb12856),
                            shape = RoundedCornerShape(16.dp)
                        ),
                    shape = RoundedCornerShape(16.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color.Transparent,
                        focusedBorderColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                    ),
                )
            }

            Spacer(modifier = Modifier.padding(1.dp))
            Button(
                    onClick = {
                        if (viewModel.selectedCardIndex == 0) {
                            if (viewModel.hospitalRegistrationNumber != ""
                                && viewModel.hospitalPassword != ""
                            ) {

                            } else {
                                showToast = true
                            }
                        }
                    },
                    modifier = Modifier
                        .padding(16.dp)
                        .size(180.dp, 70.dp),
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(
                        Color(0xFFb12856)
                    )
                ) {
                    Text(
                        text = "Sign In",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

        }
    }
}