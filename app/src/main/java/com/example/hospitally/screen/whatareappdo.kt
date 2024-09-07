package com.example.hospitally.screen

import android.media.Image
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.PagerSnapDistance
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.fontscaling.MathUtils.lerp
import androidx.navigation.NavController
import com.example.hospitally.R
import com.example.hospitally.dataclass.CardData
import com.example.hospitally.navigation.navigate
import com.tbuonomo.viewpagerdotsindicator.compose.DotsIndicator
import com.tbuonomo.viewpagerdotsindicator.compose.model.DotGraphic
import com.tbuonomo.viewpagerdotsindicator.compose.type.ShiftIndicatorType
import kotlin.math.absoluteValue


@Composable
fun CardComponents(
    title:String,
    description:String,
    images:Int,
) {
    Card(
        modifier = Modifier
            .padding(1.dp)
            .fillMaxWidth(0.95f),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp,
            pressedElevation = 16.dp
        ),
        content = {
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .fillMaxSize(0.5f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Image(
                    painter = painterResource(id = images),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = title
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = description,
                )
            }
        },
        border = BorderStroke(3.dp, Color(0xFFb12856))
    )



}


@Composable
fun mains(navController: NavController){

    val cards = listOf(
        CardData(
            title = "Card 1",
            description = "Description 1",
            image = R.drawable.bedavailability
        ),
        CardData(
            title = "Card 2",
            description = "Description 2",
            image = R.drawable.queue
        ),
        CardData(
            title = "Card 3",
            description = "Description 3",
            image = R.drawable.medication

        ),
        CardData(
            title = "Card 4",
            description = "Description 4",
            image = R.drawable.admission
        ),
    )

    SlidingCordAnimation(
        cards = cards,
        onCardSelected = {},
        navController
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SlidingCordAnimation(
    cards: List<CardData>,
    onCardSelected:(Int) -> Unit,
    navController: NavController

) {
    val pagerState = rememberPagerState(pageCount = { cards.size })

    val fling = PagerDefaults.flingBehavior(
        state = pagerState,
        pagerSnapDistance = PagerSnapDistance.atMost(10)
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        HorizontalPager(
            state = pagerState,
            beyondViewportPageCount = 2,
            flingBehavior = fling,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f)
                .padding(16.dp),

            ) { page ->
            val pageOffset = pagerState.getOffsetDistanceInPages(page)
                .absoluteValue
            val scale = lerp(0.7f, 1f, 1 - pageOffset.coerceIn(0f, 1f))
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .graphicsLayer {
                            scaleX = scale
                            scaleY = scale
                            // Adjust alpha to create a subtle fading effect
                            alpha = lerp(0.5f, 1f, 1 - pageOffset.coerceIn(0f, 1f))
                        }
                        .fillMaxWidth()
                        .height(850.dp * (1 - pageOffset))
                ) {

                    CardComponents(
                        title = cards[page].title,
                        description = cards[page].description,
                        images = cards[page].image
                    )
                }
            }

        if (pagerState.currentPage == cards.size - 1) {
            Button(
                onClick = {
                    navController.navigate("optionstochoose")
                },
                modifier = Modifier.padding(16.dp)
                    .size(100.dp,50.dp)
                    .align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(
                    Color(0xFFb12856)
                )
            ) {
                Text("Next")
            }
        }
            DotsIndicator(
                dotCount = 4,
                type = ShiftIndicatorType(
                    dotsGraphic = DotGraphic(
                        color = Color(0xFFb12856)
                    )
                ),
                pagerState = pagerState,
            )


    }


}