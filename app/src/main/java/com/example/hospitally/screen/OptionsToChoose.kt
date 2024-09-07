package com.example.hospitally.screen

import android.graphics.drawable.Icon
import android.icu.text.CaseMap.Title
import android.widget.Toast
import androidx.collection.emptyLongSet
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.hospitally.R
import com.example.hospitally.viewmodel.HospitalInfo

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun OptionsToChoose(navController: NavController,viewModel: HospitalInfo) {
    val cards = listOf(
        Pair("Hospital", R.drawable.hospital),
        Pair("Staff", R.drawable.staff),
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        FlowRow(
            modifier = Modifier
                .padding(top = 18.dp),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ){
                cards.forEachIndexed{index, cardData ->
                    CardDetails(title = cardData.first,
                        imageRes = cardData.second,
                        isSelected = viewModel.selectedCardIndex==index,
                        onCardClick = {
                        viewModel.selectedCardIndex = index
                    })
                }
            }
        }
        Spacer(modifier = Modifier.height(40.dp))

        if(viewModel.selectedCardIndex == 0) {
            RegisterYourHospital(navController, viewModel)
        }
        else if(viewModel.selectedCardIndex == 1){
            RegisterYourStaffs(navController,viewModel)
            }
        }
    }


@Composable
fun CardDetails(title: String,imageRes:Int,isSelected:Boolean = false,onCardClick:()->Unit){
    Column {
        Card(
            modifier = Modifier
                .padding(1.dp)
                .size(150.dp)
                .clickable {
                    onCardClick()
                },
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp,
                pressedElevation = 16.dp
            ),
            border = BorderStroke(3.dp, Color(0xFFb12856))
        ) {
            Box(
                modifier = Modifier
                    .background(
                        if(isSelected) Color(0xFFb12856) else Color.Gray
                    ),
            ){
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = "Staff"
                )

                if(isSelected){
                    Icon(
                        painter = painterResource(id = R.drawable.icontick),
                        contentDescription = "Check",
                        tint = Color.Black,
                        modifier = Modifier
                            .padding(8.dp)
                            .size(34.dp)
                            .align(Alignment.BottomEnd)
                    )
                }
                else{
                    Icon(
                        painter = painterResource(id = R.drawable.circle),
                        contentDescription = "Check",
                        tint = Color.Black,
                        modifier = Modifier
                            .padding(8.dp)
                            .size(34.dp)
                            .align(Alignment.BottomEnd)
                    )
                }
            }
        }

        Text(
            text = title,
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterHorizontally),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
        )

    }
}