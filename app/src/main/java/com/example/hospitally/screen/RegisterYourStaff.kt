package com.example.hospitally.screen

import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.hospitally.viewmodel.HospitalInfo


@Composable
fun RegisterYourStaffs(navController: NavController,viewModel: HospitalInfo) {
    var showToast by rememberSaveable { mutableStateOf(false) }
    val context = LocalContext.current // Access context inside Composable

    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Column (
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                Text(text = "StaffName",
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 25.sp
                )
                OutlinedTextField(
                    value = viewModel.staffName,
                    onValueChange = {
                        viewModel.staffName = it
                    },
                    modifier = Modifier
                        .border(width = 3.dp, color = Color(0xFFb12856), shape = RoundedCornerShape(16.dp)),
                    shape = RoundedCornerShape(16.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color.Transparent,
                        focusedBorderColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                    ),

                    )
            }

            Column (
                modifier = Modifier.fillMaxSize()
                    .padding(top = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                Text("Staff Id",
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 25.sp
                )
                OutlinedTextField(
                    value = viewModel.staffId,
                    onValueChange = {
                        viewModel.staffId = it
                    },
                    modifier = Modifier
                        .border(width = 3.dp, color = Color(0xFFb12856), shape = RoundedCornerShape(16.dp)),
                    shape = RoundedCornerShape(16.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color.Transparent,
                        focusedBorderColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                    ),
                )
            }

            Column (
                modifier = Modifier.fillMaxSize()
                    .padding(top = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                Text("Email",
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 25.sp
                )
                OutlinedTextField(
                    value = viewModel.staffEmail,
                    onValueChange = {
                        viewModel.staffEmail = it
                    },
                    modifier = Modifier
                        .border(width = 3.dp, color = Color(0xFFb12856), shape = RoundedCornerShape(16.dp)),
                    shape = RoundedCornerShape(16.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color.Transparent,
                        focusedBorderColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                    ),
                )
            }

            Column (
                modifier = Modifier.fillMaxSize()
                    .padding(top = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                Text("Password",
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 25.sp
                )
                OutlinedTextField(
                    value = viewModel.staffPassword,
                    onValueChange = {
                        viewModel.staffPassword = it
                    },
                    modifier = Modifier
                        .border(width = 3.dp, color = Color(0xFFb12856), shape = RoundedCornerShape(16.dp)),
                    shape = RoundedCornerShape(16.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color.Transparent,
                        focusedBorderColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                    ),
                )
            }

            Spacer(modifier = Modifier.padding(18.dp))
            Row {
                Button(
                    onClick = {
                        if(viewModel.selectedCardIndex == 1){
                            if(viewModel.staffName!=""
                                && viewModel.staffId!=""
                                && viewModel.staffContactNumber!=""
                                && viewModel.staffEmail!=""
                                && viewModel.staffPassword!=""
                                && viewModel.staffDesignation!=""
                            ){

                            }else{
                                showToast = true
                            }
                        }
                    },
                    modifier = Modifier
                        .padding(16.dp)
                        .size(180.dp,70.dp),
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(
                        Color(0xFFb12856)
                    )
                ) {
                    Text(
                        text = "Sign Up",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Button(
                    onClick = {
                        if(viewModel.selectedCardIndex == 1){
                            navController.navigate("signinstaff")
                        }
                    },
                    modifier = Modifier
                        .padding(16.dp)
                        .size(180.dp,70.dp),
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(
                        Color(0xFFb12856)
                    )
                ) {
                    Text(
                        text = "Have an account?",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                }
            }

            if(showToast) {
                Toast.makeText(context, "Please fill all the fields", Toast.LENGTH_SHORT).show()
            }

        }
    }
}